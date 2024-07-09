package com.internship.user_saving.service;

import com.internship.user_saving.dto.SavingAndInvestmentDTO;
import com.internship.user_saving.entity.SavingAndInvestment;

import java.time.YearMonth;
import java.util.List;

public interface SavingInvestmentServices {
    SavingAndInvestment addSavingInvestment(SavingAndInvestmentDTO savingAndInvestmentDTO);
    List<SavingAndInvestment> getAllAddedSavings();
    List<SavingAndInvestment> getSavingsByDate(YearMonth monthOfSavingsEntered);
    List<Double> getSavingsAmount(YearMonth date);
    List<SavingAndInvestment> getSavingsByDay(YearMonth monthOfSavingsEntered, int dayOfSavingsEntered);
}
