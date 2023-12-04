package com.wex.currencyconvert.domains.vos.reponses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PurchaseTransactionResponse {

    private String id;
    private LocalDateTime transactionDate;
    private String description;
    private BigDecimal purchaseAmount;
    private BigDecimal purchaseAmountConverted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public BigDecimal getPurchaseAmountConverted() {
        return purchaseAmountConverted;
    }

    public void setPurchaseAmountConverted(BigDecimal purchaseAmountConverted) {
        this.purchaseAmountConverted = purchaseAmountConverted;
    }
}
