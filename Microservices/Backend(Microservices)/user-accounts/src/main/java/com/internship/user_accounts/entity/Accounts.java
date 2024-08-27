package com.internship.user_accounts.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Data
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, updatable = false)
    private String date;

    private double income;

    private double spentOnNeeds;
    private double allocatedNeeds;
    private double spentOnWants;
    private double allocatedWants;
    private double spendOnSavings;
    private double allocatedSavings;

    private Long userId;

}
