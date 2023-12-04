package com.wex.currencyconvert.builders;

import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionPostResponse;

public class PurchaseTransactionPostResponseBuilder {

    private PurchaseTransactionPostResponse purchaseTransactionPostResponse = new PurchaseTransactionPostResponse();

    public PurchaseTransactionPostResponseBuilder withId(final String id){

        purchaseTransactionPostResponse.setId(id);
        return this;
    }

    public PurchaseTransactionPostResponse build(){
        return purchaseTransactionPostResponse;
    }
}
