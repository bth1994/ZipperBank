package io.zipcoder.entities;

import io.zipcoder.utilities.Medium;
import io.zipcoder.utilities.TransactionStatus;
import io.zipcoder.utilities.TransactionType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Deposit {

    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TransactionType type;

    private String transactionDate;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;

    private Long payeeId;

    @Enumerated(value = EnumType.STRING)
    private Medium medium;

    private Double amount;
    private String description;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return this.type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Account account) {
        this.payeeId = account.getId();
    }

    public Medium getMedium() {
        return this.medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
