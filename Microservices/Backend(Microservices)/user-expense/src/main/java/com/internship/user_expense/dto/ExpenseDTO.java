package com.internship.user_expense.dto;

import com.internship.user_expense.entity.ExpenseCategory;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class ExpenseDTO {

    private Long expenseId;

    private String date;

    private String dateOfExpense;

    private int dayOfTheMonth;

    private double amount;

    private ExpenseCategory category;

    private String description;

    private Long userId;

    public ExpenseDTO getExpenseDto(){
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setExpenseId(expenseId);
        expenseDTO.setDateOfExpense(dateOfExpense);
        expenseDTO.setCategory(category);
        expenseDTO.setDescription(description);
        expenseDTO.setDayOfTheMonth(dayOfTheMonth);
        expenseDTO.setUserId(userId);
        expenseDTO.setDate(date);
        return expenseDTO;
    }
}
