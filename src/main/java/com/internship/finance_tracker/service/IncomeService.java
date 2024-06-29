package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.entity.Income;

public interface IncomeService {
    Income addIncome(IncomeDTO incomeDTO);
}
