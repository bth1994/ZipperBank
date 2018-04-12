package io.zipcoder.entities;

import io.zipcoder.utilities.BillStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import javax.validation.groups.ConvertGroup;

@Entity
public class Bill {

    @Id
    @GeneratedValue
    @Column(name = "BILL_ID")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private BillStatus status;

    @Column(name = "PAYEE")
    private String payee;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "CREATION_DATE")
    private String creationDate;

    @Column(name = "PAYMENT DATE")
    private String paymentDate;

    @Column(name = "RECURRING_DATE")
    private Integer recurringDate;

    @Column(name = "UPCOMING_PAYMENT_DATE")
    private String upcomingPaymentDate;

    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;

    @Column(name = "ACCOUNT_ID")
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
