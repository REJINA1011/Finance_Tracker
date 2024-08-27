package com.internship.user_income_allocation.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class IncomeAllocationDTO {

    private Long incomeAllocationId;

    private String dateOfEntry;

    private double incomeAmount;

    private double expensesOnNeeds;
    private double expensesOnWants;
    private double savingAmount;

    private Long userId;

    public IncomeAllocationDTO getIncomeAllocationDto(){
        IncomeAllocationDTO incomeAllocationDto = new IncomeAllocationDTO();

        incomeAllocationDto.setIncomeAllocationId(incomeAllocationId);
        incomeAllocationDto.setIncomeAmount(incomeAmount);
        incomeAllocationDto.setExpensesOnNeeds(expensesOnNeeds);
        incomeAllocationDto.setExpensesOnWants(expensesOnWants);
        incomeAllocationDto.setSavingAmount(savingAmount);
        incomeAllocationDto.setDateOfEntry(dateOfEntry);
        incomeAllocationDto.setUserId(userId);

        return incomeAllocationDto;
    }
}
