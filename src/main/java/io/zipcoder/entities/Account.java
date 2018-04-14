package io.zipcoder.entities;

import io.zipcoder.utilities.AccountType;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE")
    private AccountType type;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REWARDS_POINTS")
    private Integer rewards;

    @Column(name = "ACCOUNT_BALANCE")
    private Double balance;
    
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID")
    private Long customerId;

    public Account(){}

    public Account(String nickname, AccountType type, Double balance, Long customerId){
        this.nickname = nickname;
        this.type = type;
        this.balance = balance;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getType() {
        return this.type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
