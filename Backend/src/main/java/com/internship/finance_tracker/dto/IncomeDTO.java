package com.internship.finance_tracker.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class IncomeDTO {

    private Long incomeId;

    private YearMonth dateOfEntry;

    private double amount;

    private String category;

    private String description;

    public IncomeDTO getIncomeDto(){
        IncomeDTO incomeDto = new IncomeDTO();

        incomeDto.setIncomeId(incomeId);
        incomeDto.setCategory(category);
        incomeDto.setAmount(amount);
        incomeDto.setDescription(description);
        incomeDto.setDateOfEntry(dateOfEntry);

        return incomeDto;
    }
}
