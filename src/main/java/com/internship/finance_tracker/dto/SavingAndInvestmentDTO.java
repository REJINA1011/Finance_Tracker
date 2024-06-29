package com.internship.finance_tracker.dto;

import com.internship.finance_tracker.entity.SavingAndInvestmentCategory;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class SavingAndInvestmentDTO {
    private Long savingInvestmentId;

    private YearMonth dateOfEntry;

    private double amount;

    private SavingAndInvestmentCategory category;

    private String description;

    public SavingAndInvestmentDTO getSavingDto(){
       SavingAndInvestmentDTO savingInvestmentDto = new SavingAndInvestmentDTO();

       savingInvestmentDto.setSavingInvestmentId(savingInvestmentId);
       savingInvestmentDto.setDateOfEntry(dateOfEntry);
       savingInvestmentDto.setCategory(category);
       savingInvestmentDto.setAmount(amount);
       savingInvestmentDto.setDescription(description);

        return savingInvestmentDto;
    }
}
