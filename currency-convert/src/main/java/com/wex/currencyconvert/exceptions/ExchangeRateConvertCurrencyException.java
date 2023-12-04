package com.wex.currencyconvert.exceptions;

import com.wex.currencyconvert.enums.IssueEnum;

public class ExchangeRateConvertCurrencyException extends GlobalException{

    private static final long serialVersionUID = 1L;

    protected ExchangeRateConvertCurrencyException(final Issue issue){
        super(issue);
    }

    public static ExchangeRateConvertCurrencyException purchaseCannotConverted() {

        return new ExchangeRateConvertCurrencyException(new Issue(IssueEnum.PURCHASE_CANNOT_CONVERTED));
    }
}
