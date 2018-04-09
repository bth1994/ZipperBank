package io.zipcoder.entities;

import io.zipcoder.utilities.Medium;
import io.zipcoder.utilities.TransactionStatus;
import io.zipcoder.utilities.TransactionType;

import javax.persistence.Entity;

@Entity
public class Deposit {

    private Long id;
    private TransactionType type;
    private String transactionDate;
    private TransactionStatus status;
    private Long payeeId;
    private Medium medium;
    private Double amount;
    private String description;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type.getValue();
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

    public String getStatus() {
        return this.status.getValue();
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

    public String getMedium() {
        return this.medium.getValue();
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
