package com.internship.user_saving.entity;

import  jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Data
public class SavingAndInvestment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingId;

    @Column(nullable = false, updatable = false)
    private String dateOfEntry;

    @Column(nullable = false, updatable = false)
    private int dayOfTheMonth;

    private double amount;

    private Long userId;

    @Column(nullable = false, updatable = false)
    private String date;

    @Enumerated(EnumType.STRING)
    private SavingAndInvestmentCategory category;

    private String description;

    @PrePersist
    protected void onCreate() {

        dateOfEntry = YearMonth.now().toString();
        dayOfTheMonth=LocalDate.now().getDayOfMonth();
        date=LocalDate.now().toString();
    }
}
