package com.internship.user_expense.dto;

import com.internship.user_expense.entity.ExpenseCategory;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class ExpenseDTO {

    private Long expenseId;

    private YearMonth dateOfExpense;

    private int dayOfTheMonth;

    private double amount;

    private ExpenseCategory category;

    private String title;

    private String description;


    public ExpenseDTO getExpenseDto(){
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setExpenseId(expenseId);
        expenseDTO.setDateOfExpense(dateOfExpense);
        expenseDTO.setTitle(title);
        expenseDTO.setCategory(category);
        expenseDTO.setDescription(description);
        expenseDTO.setDayOfTheMonth(dayOfTheMonth);

        return expenseDTO;
    }
}
