package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.SavingAndInvestmentDTO;
import com.internship.finance_tracker.entity.SavingAndInvestment;

import java.time.YearMonth;
import java.util.List;

public interface SavingInvestmentServices {
    SavingAndInvestment addSavingInvestment(SavingAndInvestmentDTO savingAndInvestmentDTO);
    List<SavingAndInvestment> getAllAddedSavings();
    List<SavingAndInvestment> getSavingsByDate(YearMonth monthOfSavingsEntered);
    List<SavingAndInvestment> getSavingsByDay(YearMonth monthOfSavingsEntered, int dayOfSavingsEntered);
}
