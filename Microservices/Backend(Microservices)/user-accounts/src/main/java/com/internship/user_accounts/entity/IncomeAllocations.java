package com.internship.user_accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeAllocations {
    private Long incomeAllocationId;

    private String dateOfEntry;

    private double incomeAmount;

    private double expensesOnNeeds;
    private double expensesOnWants;

    private double savingAmount;

    private Long userId;

}
