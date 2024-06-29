package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.ExpenseDTO;
import com.internship.finance_tracker.entity.Expenses;

public interface ExpenseService {
    Expenses addExpenses(ExpenseDTO expenseDTO);
}
