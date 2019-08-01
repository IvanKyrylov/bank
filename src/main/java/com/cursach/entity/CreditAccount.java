package com.cursach.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "credit_account")
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "num")
    private Long num;

    @Column(name = "credit_limit")
    private Long creditLimit;

    @Column(name = "credit")
    private Long credit;

    @Column(name = "percent")
    private Long percent;

    @Column(name = "interest_rate")
    private Long interestRate;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "return_time")
    private Timestamp return_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditAccount")
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

    public Long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

    public Long getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Long interestRate) {
        this.interestRate = interestRate;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Timestamp return_time) {
        this.return_time = return_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ReplenishmentHistory> getReplenishmentHistories() {
        return replenishmentHistories;
    }

    public void setReplenishmentHistories(Set<ReplenishmentHistory> replenishmentHistories) {
        this.replenishmentHistories = replenishmentHistories;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", num=" + num +
                ", creditLimit=" + creditLimit +
                ", credit=" + credit +
                ", percent=" + percent +
                ", interestRate=" + interestRate +
                ", createTime=" + createTime +
                ", return_time=" + return_time +
                ", user=" + user +
                ", replenishmentHistories=" + replenishmentHistories +
                '}';
    }
}
