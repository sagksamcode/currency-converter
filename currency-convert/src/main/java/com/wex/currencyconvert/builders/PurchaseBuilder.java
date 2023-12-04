package com.wex.currencyconvert.builders;

import com.wex.currencyconvert.domains.vos.models.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PurchaseBuilder {

    private Purchase purchase = new Purchase();

    public PurchaseBuilder withId(final String id){

        purchase.setId(id);
        return this;
    }
    public PurchaseBuilder withDescription(final String description){

        purchase.setDescription(description);
        return this;
    }

    public PurchaseBuilder withAmount(final BigDecimal amount){

        purchase.setAmount(amount);
        return this;
    }

    public PurchaseBuilder withDate(final LocalDateTime date){

        purchase.setDate(date);
        return this;
    }

    public Purchase build(){

        return purchase;
    }
}
