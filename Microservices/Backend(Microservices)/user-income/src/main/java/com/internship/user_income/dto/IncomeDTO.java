package com.internship.user_income.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class IncomeDTO {

    private Long incomeId;

    private String dateOfEntry;

    private double amount;

    private String category;

    private String description;

    private int dayOfTheMonth;

    private Long userId;

    private String date;
    public IncomeDTO getIncomeDto(){
        IncomeDTO incomeDto = new IncomeDTO();

        incomeDto.setIncomeId(incomeId);
        incomeDto.setCategory(category);
        incomeDto.setAmount(amount);
        incomeDto.setDescription(description);
        incomeDto.setDateOfEntry(dateOfEntry);
        incomeDto.setDayOfTheMonth(dayOfTheMonth);
        incomeDto.setUserId(userId);
        incomeDto.setDate(date);

        return incomeDto;
    }
}
