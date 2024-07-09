package com.internship.user_expense.service;

import com.internship.user_expense.dto.ExpenseDTO;
import com.internship.user_expense.entity.ExpenseCategory;
import com.internship.user_expense.entity.Expenses;
import com.internship.user_expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

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

    public List<Expenses> getAllAddedExpense() {
        return expenseRepository.findAll();
    }

    public List<Expenses> getExpenseByDate(YearMonth monthOfExpenseEntered) {
        return expenseRepository.findAllByMonth(monthOfExpenseEntered);
    }

    public List<Expenses> getExpenseByDay(YearMonth monthOfExpenseEntered, int dayOfExpenseEntered) {
        return expenseRepository.findByDay(monthOfExpenseEntered,dayOfExpenseEntered);

    }

    public List<Double> getAllExpensesByCategory(YearMonth yearMonth, ExpenseCategory category) {
        return expenseRepository.getAmountsAsPerCategory(yearMonth,category);
    }
}
