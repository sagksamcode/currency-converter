package com.wex.currencyconvert.domains.vos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseTransactionRequest {

    @NotEmpty
    @Pattern(regexp = "^.{1,50}$", message = "Description must not exceed 50 characters")
    private String description;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private LocalDateTime transactionDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
