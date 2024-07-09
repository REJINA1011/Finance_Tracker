package com.internship.user_expense.service;

import com.internship.user_expense.dto.ExpenseDTO;
import com.internship.user_expense.entity.Expenses;

import java.time.YearMonth;
import java.util.List;

public interface ExpenseService {
    Expenses addExpenses(ExpenseDTO expenseDTO);
    List<Expenses> getAllAddedExpense();
    List<Expenses> getExpenseByDate(YearMonth monthOfExpenseEntered);
    List<Expenses> getExpenseByDay(YearMonth monthOfExpenseEntered, int dayOfExpenseEntered);
}
