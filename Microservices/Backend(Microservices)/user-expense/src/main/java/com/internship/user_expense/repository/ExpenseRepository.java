package com.internship.user_expense.repository;

import com.internship.user_expense.entity.ExpenseCategory;
import com.internship.user_expense.entity.Expenses;
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
    List<Double> getAmountsAsPerCategory(String date, ExpenseCategory category);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:monthOfExpenseEntered")
    List<Expenses> findAllByMonth(String monthOfExpenseEntered);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:monthOfExpenseEntered AND expense.dayOfTheMonth=:dayOfExpenseEntered")
    List<Expenses> findByDay(String monthOfExpenseEntered, int dayOfExpenseEntered);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:yearMonth AND expense.dayOfTheMonth=:dayOfEntry AND expense.category=:category ")
    List<Expenses> getExpensesEachDayAsPerCategory(String yearMonth, int dayOfEntry, ExpenseCategory category);

    @Query("SELECT expense.amount FROM Expenses expense WHERE expense.dateOfExpense=:yearMonth AND expense.dayOfTheMonth=:dayOfEntry AND expense.category=:category ")
    List<Double> getAmountsAsPerDayAndCategory(String yearMonth, int dayOfEntry, ExpenseCategory category);
}
