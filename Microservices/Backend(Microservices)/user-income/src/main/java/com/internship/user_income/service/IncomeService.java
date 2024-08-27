package com.internship.user_income.service;

import com.internship.user_income.dto.IncomeDTO;
import com.internship.user_income.entity.Income;

import java.time.YearMonth;
import java.util.List;

public interface IncomeService {
    Income addIncome(IncomeDTO incomeDTO,Long userId);
    List<Income> getAllAddedIncomes();
    List<Income> getIncomesByDate(String dateOfIncomeEntered, Long userId);
}
