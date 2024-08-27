package com.internship.user_expense.service;

import com.internship.user_expense.dto.ExpenseDTO;
import com.internship.user_expense.entity.Expenses;

import java.time.YearMonth;
import java.util.List;

public interface ExpenseService {
    Expenses addExpenses(ExpenseDTO expenseDTO, String email);
    List<Expenses> getAllAddedExpense();
    List<Expenses> getExpenseByDate(String monthOfExpenseEntered,Long userId);
    List<Expenses> getExpenseByDay(String monthOfExpenseEntered, int dayOfExpenseEntered);
}
