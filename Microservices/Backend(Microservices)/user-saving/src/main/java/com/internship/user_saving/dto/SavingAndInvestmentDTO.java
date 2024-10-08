package com.internship.user_saving.dto;

import com.internship.user_saving.entity.SavingAndInvestmentCategory;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class SavingAndInvestmentDTO {
    private Long savingInvestmentId;

    private String dateOfEntry;

    private double amount;

    private SavingAndInvestmentCategory category;

    private String description;

    private int dayOfTheMonth;

    private Long userId;

    private String date;
    public SavingAndInvestmentDTO getSavingDto(){
       SavingAndInvestmentDTO savingInvestmentDto = new SavingAndInvestmentDTO();

       savingInvestmentDto.setSavingInvestmentId(savingInvestmentId);
       savingInvestmentDto.setDateOfEntry(dateOfEntry);
       savingInvestmentDto.setCategory(category);
       savingInvestmentDto.setAmount(amount);
       savingInvestmentDto.setDescription(description);
       savingInvestmentDto.setDayOfTheMonth(dayOfTheMonth);
       savingInvestmentDto.setUserId(userId);
       savingInvestmentDto.setDate(date);

        return savingInvestmentDto;
    }
}
