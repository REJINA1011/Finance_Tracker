package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.ExpenseDTO;
import com.internship.finance_tracker.entity.Expenses;

import java.time.YearMonth;
import java.util.List;

public interface ExpenseService {
    Expenses addExpenses(ExpenseDTO expenseDTO);
    List<Expenses> getAllAddedExpense();
    Expenses getExpenseByDate(YearMonth monthOfExpenseEntered);
    List<Expenses> getExpenseByDay(YearMonth monthOfExpenseEntered, int dayOfExpenseEntered);
}
