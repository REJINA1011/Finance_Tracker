package com.internship.finance_tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Data
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @Column(nullable = false, updatable = false)
    private YearMonth dateOfExpense;

    @Column(nullable = false, updatable = false)
    private int dayOfTheMonth;

    private double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    private String title;

    private String description;

    @PrePersist
    protected void onCreate() {
        dateOfExpense = YearMonth.now();// Set the entry date before persisting
        dayOfTheMonth=LocalDate.now().getDayOfMonth();
    }
}
