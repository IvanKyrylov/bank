package com.cursach.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "deposit_account")
public class DepositAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "num")
    private Long num;

    @Column(name = "deposit_amount")
    private Long deposit_amount;

    @Column(name = "rate")
    private Long rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depositAccount")
    private Set<ReplenishmentHistory> replenishmentHistories = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(Long deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "DepositAccount{" +
                "id=" + id +
                ", num=" + num +
                ", deposit_amount=" + deposit_amount +
                ", rate=" + rate +
                ", user=" + user +
                ", replenishmentHistories=" + replenishmentHistories +
                '}';
    }
}
