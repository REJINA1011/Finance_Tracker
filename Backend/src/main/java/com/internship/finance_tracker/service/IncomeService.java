package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.entity.Income;

import java.time.YearMonth;
import java.util.List;

public interface IncomeService {
    Income addIncome(IncomeDTO incomeDTO);
    List<Income> getAllAddedIncomes();
    List<Income> getIncomesByDate(YearMonth dateOfIncomeEntered);
}
