package com.cursach.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "replenishment_history")
public class ReplenishmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "replenishment_time")
    private Timestamp replenishmentTime;

    @Column(name = "sum")
    private Long sum;

    @ManyToOne
    @JoinColumn(name = "deposit_account_id")
    private DepositAccount depositAccount;

    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private CreditAccount creditAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getReplenishmentTime() {
        return replenishmentTime;
    }

    public void setReplenishmentTime(Timestamp replenishmentTime) {
        this.replenishmentTime = replenishmentTime;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public DepositAccount getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(DepositAccount depositAccount) {
        this.depositAccount = depositAccount;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Override
    public String toString() {
        return "ReplenishmentHistory{" +
                "id=" + id +
                ", replenishmentTime=" + replenishmentTime +
                ", sum=" + sum +
                ", depositAccount=" + depositAccount +
                ", creditAccount=" + creditAccount +
                '}';
    }
}
