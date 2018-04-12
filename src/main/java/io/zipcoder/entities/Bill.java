package io.zipcoder.entities;

import io.zipcoder.utilities.BillStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Bill {

    private Long id;

    @Enumerated(value = EnumType.STRING)
    private BillStatus status;

    private String payee;
    private String nickname;
    private String creationDate;
    private String paymentDate;
    private Integer recurringDate;
    private String upcomingPaymentDate;
    private Double paymentAmount;
    private Long accountId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BillStatus getStatus() {
        return this.status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getRecurringDate() {
        return recurringDate;
    }

    public void setRecurringDate(Integer recurringDate) {
        this.recurringDate = recurringDate;
    }

    public String getUpcomingPaymentDate() {
        return upcomingPaymentDate;
    }

    public void setUpcomingPaymentDate(String upcomingPaymentDate) {
        this.upcomingPaymentDate = upcomingPaymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Account account) {
        this.accountId = account.getId();
    }

}
