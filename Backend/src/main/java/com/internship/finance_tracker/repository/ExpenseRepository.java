package com.internship.finance_tracker.repository;

import com.internship.finance_tracker.entity.ExpenseCategory;
import com.internship.finance_tracker.entity.Expenses;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

    @Query("SELECT expense.amount FROM Expenses expense WHERE expense.dateOfExpense=:date AND expense.category=:category ")
    List<Double> getAmountsAsPerCategory(YearMonth date, ExpenseCategory category);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:monthOfExpenseEntered")
    Expenses findALlByMonth(YearMonth monthOfExpenseEntered);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:monthOfExpenseEntered AND expense.dayOfTheMonth=:dayOfExpenseEntered")
    List<Expenses> findByDay(YearMonth monthOfExpenseEntered, int dayOfExpenseEntered);
}
