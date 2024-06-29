package com.internship.finance_tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
@Entity
public class SavingAndInvestment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingId;

    @Column(nullable = false, updatable = false)
    private YearMonth dateOfEntry;

    private double amount;

    @Enumerated(EnumType.STRING)
    private SavingAndInvestmentCategory category;

    private String description;

    @PrePersist
    protected void onCreate() {
        dateOfEntry = YearMonth.now(); // Set the entry date before persisting
    }
}
