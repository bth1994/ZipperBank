package io.zipcoder.entities;

import io.zipcoder.utilities.Medium;
import io.zipcoder.utilities.TransactionStatus;
import io.zipcoder.utilities.TransactionType;


import javax.persistence.*;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue
    @Column(name = "WITHDRAWAL_ID")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "TRANSACTION_TYPE")
    private TransactionType type;

    @Column(name = "TRANSACTION_DATE")
    private String transactionDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "TRANSACTION_STATUS")
    private TransactionStatus status;

    @Column(name = "PAYER_ID")
    private Long payerId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MEDIUM")
    private Medium medium;

    @Column(name = "WITHDRAWAL_AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
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
        return payerId;
    }

    public void setPayeeId(Account account) {
        this.payerId = account.getId();
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
