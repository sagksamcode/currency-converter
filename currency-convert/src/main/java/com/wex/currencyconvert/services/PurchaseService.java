package com.wex.currencyconvert.services;

import com.wex.currencyconvert.builders.PurchaseBuilder;
import com.wex.currencyconvert.builders.PurchaseTransactionPostResponseBuilder;
import com.wex.currencyconvert.builders.PurchaseTransactionResponseBuilder;
import com.wex.currencyconvert.domains.vos.models.Purchase;
import com.wex.currencyconvert.domains.vos.reponses.ExchangeRatesResponse;
import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionPostResponse;
import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionResponse;
import com.wex.currencyconvert.domains.vos.requests.PurchaseTransactionRequest;
import com.wex.currencyconvert.exceptions.ExchangeRateConvertCurrencyException;
import com.wex.currencyconvert.exceptions.NotFoundException;
import com.wex.currencyconvert.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseService {

    @Autowired
    private final PurchaseRepository repository;
    private static final String API = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/v1/accounting/od/rates_of_exchange";

    @Autowired
    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public PurchaseTransactionPostResponse insert (PurchaseTransactionRequest request){

        final Purchase purchase = new PurchaseBuilder().withId(UUID.randomUUID().toString())
                .withDescription(request.getDescription())
                .withDate(request.getTransactionDate())
                .withAmount(request.getAmount())
                .build();

        final PurchaseTransactionPostResponse purchaseTransactionPostResponse = new PurchaseTransactionPostResponseBuilder()
                .withId(purchase.getId())
                        .build();

        repository.save(purchase);
        return purchaseTransactionPostResponse;
    }

    public PurchaseTransactionResponse retrievePurchase(final String purchaseId, final String country){

        final Optional<Purchase> purchase = repository.findById(purchaseId);
        if(purchase.isPresent()){
            return calculateExchange(purchase.get(), country);
        }
        throw NotFoundException.notFoundId();
    }

    private PurchaseTransactionResponse calculateExchange(final Purchase purchase, final String country){

        final BigDecimal exchangeRateValue = exchangeRate(purchase, country);
        return new PurchaseTransactionResponseBuilder()
                .withId(purchase.getId())
                .withDescription(purchase.getDescription())
                .withTransactionDate(purchase.getDate())
                .withPurchaseAmount(purchase.getAmount())
                .withPurchaseAmountConverted(convertPurchaseAmount(purchase.getAmount(), exchangeRateValue))
                .build();
    }

    private BigDecimal exchangeRate(final Purchase purchase, String country){

        try {
            List<ExchangeRatesResponse.ExchangeRateData> exchangeRatesResponse = fetchAllExchangeRates(country).getData();
            if(!exchangeRatesResponse.isEmpty()){
                ExchangeRatesResponse.ExchangeRateData exchangeRate = findAppropriateExchangeRate(exchangeRatesResponse, purchase.getDate());
                return new BigDecimal(exchangeRate.getExchange_rate());
            }
            else {
                throw NotFoundException.notFoundCountry();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public BigDecimal convertPurchaseAmount(BigDecimal purchaseAmount, BigDecimal exchangeRateValue){
        BigDecimal convertedAmount = purchaseAmount.multiply(exchangeRateValue);
        convertedAmount = convertedAmount.setScale(2, RoundingMode.HALF_UP);
        return convertedAmount;
    }

    private ExchangeRatesResponse.ExchangeRateData findAppropriateExchangeRate(List<ExchangeRatesResponse.ExchangeRateData> exchangeRates, LocalDateTime transactionDate) {
        ExchangeRatesResponse.ExchangeRateData rateUsed = null;
        long closestMonthsDifference = Long.MAX_VALUE;

        for (ExchangeRatesResponse.ExchangeRateData rateData : exchangeRates) {
            String recordDateString = rateData.getRecord_date();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate recordDate = LocalDate.parse(recordDateString, formatter);

            LocalDateTime midnightRecordDate = recordDate.atStartOfDay();

            long monthsDifference = transactionDate.until(midnightRecordDate, ChronoUnit.MONTHS);

            if (monthsDifference <= 6 && monthsDifference < closestMonthsDifference) {
                rateUsed = rateData;
                closestMonthsDifference = monthsDifference;
            }
        }

        if (rateUsed != null) {
            return rateUsed;
        } else {
            throw ExchangeRateConvertCurrencyException.purchaseCannotConverted();
        }
    }

    private ExchangeRatesResponse fetchAllExchangeRates(String countryCurrency) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ExchangeRatesResponse> initialResponse = fetchDataForPage(restTemplate, countryCurrency, 1);

        if (initialResponse.getStatusCode().is2xxSuccessful()) {
            ExchangeRatesResponse initialExchangeRatesResponse = initialResponse.getBody();
            int totalPages = initialExchangeRatesResponse != null ? initialExchangeRatesResponse.getMeta().getTotal_pages() : 0;

            ExchangeRatesResponse combinedResponse = initialExchangeRatesResponse;

            for (int page = 2; page <= totalPages; page++) {
                ResponseEntity<ExchangeRatesResponse> pageResponse = fetchDataForPage(restTemplate, countryCurrency, page);

                if (pageResponse.getStatusCode().is2xxSuccessful()) {
                    ExchangeRatesResponse pageExchangeRatesResponse = pageResponse.getBody();
                    combinedResponse.getData().addAll(pageExchangeRatesResponse != null ? pageExchangeRatesResponse.getData() : null);
                } else {
                    throw new RuntimeException("Failed to retrieve data from the API.");
                }
            }

            return combinedResponse;
        } else {
            throw new RuntimeException("Failed to retrieve data from the API.");
        }
    }

    private ResponseEntity<ExchangeRatesResponse> fetchDataForPage(RestTemplate restTemplate, String countryCurrency, int page) {
        String apiUrl = buildApiUrl(countryCurrency, page);
        return restTemplate.exchange(apiUrl, HttpMethod.GET, null, ExchangeRatesResponse.class);
    }

    private String buildApiUrl(String countryCurrency, int page) {
        return API + "?sort=-record_calendar_year,-record_calendar_month,-record_calendar_day" +
                "&filter=country_currency_desc:eq:" + countryCurrency +
                "&page[number]=" + page;
    }

}
