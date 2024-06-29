package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.ExpenseDTO;
import com.internship.finance_tracker.entity.ExpenseCategory;
import com.internship.finance_tracker.entity.Expenses;
import com.internship.finance_tracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    private Expenses saveOrUpdateExpenseDetails(Expenses expenses, ExpenseDTO expenseDTO){

        expenses.setAmount(expenseDTO.getAmount());
        expenses.setExpenseId(expenseDTO.getExpenseId());
        expenses.setDateOfExpense(expenseDTO.getDateOfExpense());
        expenses.setDescription(expenseDTO.getDescription());
        expenses.setTitle(expenseDTO.getTitle());

        ExpenseCategory categoryCheck=expenseDTO.getCategory();
        if (categoryCheck == ExpenseCategory.NEEDS || categoryCheck== ExpenseCategory.WANTS) {
            expenses.setCategory(categoryCheck);
        }

        return expenseRepository.save(expenses);
    }

    public Expenses addExpenses(ExpenseDTO expenseDTO) {
        return saveOrUpdateExpenseDetails(new Expenses(), expenseDTO);
    }
}
