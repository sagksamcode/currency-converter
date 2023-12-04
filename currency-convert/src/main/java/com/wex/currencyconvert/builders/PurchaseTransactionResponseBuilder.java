package com.wex.currencyconvert.builders;

import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionPostResponse;
import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseTransactionResponseBuilder {

    private PurchaseTransactionResponse purchaseTransactionResponse = new PurchaseTransactionResponse();

    public PurchaseTransactionResponseBuilder withId(final String id){

        purchaseTransactionResponse.setId(id);
        return this;
    }

    public PurchaseTransactionResponseBuilder withTransactionDate(final LocalDateTime transactionDate){

        purchaseTransactionResponse.setTransactionDate(transactionDate);
        return this;
    }

    public PurchaseTransactionResponseBuilder withDescription(final String description){

        purchaseTransactionResponse.setDescription(description);
        return this;
    }

    public PurchaseTransactionResponseBuilder withPurchaseAmount(final BigDecimal purchaseAmount){

        purchaseTransactionResponse.setPurchaseAmount(purchaseAmount);
        return this;
    }

    public PurchaseTransactionResponseBuilder withPurchaseAmountConverted(final BigDecimal purchaseAmountConverted){

        purchaseTransactionResponse.setPurchaseAmountConverted(purchaseAmountConverted);
        return this;
    }

    public PurchaseTransactionResponse build(){
        return purchaseTransactionResponse;
    }
}
