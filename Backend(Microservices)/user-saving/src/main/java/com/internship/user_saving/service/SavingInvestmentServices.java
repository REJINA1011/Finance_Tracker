package com.internship.user_saving.service;

import com.internship.user_saving.dto.SavingAndInvestmentDTO;
import com.internship.user_saving.entity.SavingAndInvestment;

import java.time.YearMonth;
import java.util.List;

public interface SavingInvestmentServices {
    SavingAndInvestment addSavingInvestment(SavingAndInvestmentDTO savingAndInvestmentDTO);
    List<SavingAndInvestment> getAllAddedSavings();
    List<SavingAndInvestment> getSavingsByDate(String monthOfSavingsEntered);
    double getSavingsAmount(String date);
    List<SavingAndInvestment> getSavingsByDay(String monthOfSavingsEntered, int dayOfSavingsEntered);
}
