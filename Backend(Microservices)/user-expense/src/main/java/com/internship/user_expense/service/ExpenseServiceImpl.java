package com.internship.user_expense.service;

import com.internship.user_expense.dto.ExpenseDTO;
import com.internship.user_expense.entity.ApiResponse;
import com.internship.user_expense.entity.ExpenseCategory;
import com.internship.user_expense.entity.Expenses;
import com.internship.user_expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public List<Expenses> getExpenseByDate(String monthOfExpenseEntered) {
        return expenseRepository.findAllByMonth(monthOfExpenseEntered);
    }

    public List<Expenses> getExpenseByDay(String monthOfExpenseEntered, int dayOfExpenseEntered) {
        return expenseRepository.findByDay(monthOfExpenseEntered,dayOfExpenseEntered);

    }

    public double getAllExpensesByCategory(String yearMonth, ExpenseCategory category) {
        double totalAmount=0;
        List<Double> amountsList=expenseRepository.getAmountsAsPerCategory(yearMonth,category);
        for(double amount:amountsList) {
            totalAmount += amount;
        }
        return totalAmount;
    }

    public List<Expenses> getAllExpensesEachDayByCategory(String yearMonth, int dayOfEntry, ExpenseCategory category) {
        return expenseRepository.getExpensesEachDayAsPerCategory(yearMonth,dayOfEntry,category);
    }

    public double getAllExpensesPerDayByCategory(String yearMonth, int dayOfEntry, ExpenseCategory category) {
        double totalAmount=0;
        List<Double> amounts=expenseRepository.getAmountsAsPerDayAndCategory(yearMonth,dayOfEntry,category);
        if (!amounts.isEmpty()) {
            for (double amount : amounts) {
                totalAmount += amount;
            }
        }
        return totalAmount;
    }
}
