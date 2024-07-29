package com.internship.user_income_allocation.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Data
public class IncomeAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeAllocationId;

    @Column(nullable = false, updatable = false)
    private String dateOfEntry;

    private double incomeAmount;

    private double expensesOnNeeds;
    private double expensesOnWants;

    private double savingAmount;


    @PrePersist
    protected void onCreate() {
        dateOfEntry = YearMonth.now().toString(); // Set the entry date before persisting
    }
}
