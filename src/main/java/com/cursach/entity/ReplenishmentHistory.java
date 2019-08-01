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


}
