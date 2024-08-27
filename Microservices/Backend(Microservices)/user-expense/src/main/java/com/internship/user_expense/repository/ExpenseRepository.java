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
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

    @Query("SELECT expense.amount FROM Expenses expense WHERE expense.dateOfExpense=:date AND expense.category=:category AND expense.userId=:userId")
    List<Double> getAmountsAsPerCategory(String date, ExpenseCategory category,Long userId);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:monthOfExpenseEntered AND expense.userId=:userId")
    List<Expenses> findAllByMonth(String monthOfExpenseEntered,Long userId);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:monthOfExpenseEntered AND expense.dayOfTheMonth=:dayOfExpenseEntered")
    List<Expenses> findByDay(String monthOfExpenseEntered, int dayOfExpenseEntered);

    @Query("SELECT expense FROM Expenses expense WHERE expense.dateOfExpense=:yearMonth AND expense.dayOfTheMonth=:dayOfEntry AND expense.category=:category AND expense.userId=:userId")
    List<Expenses> getExpensesEachDayAsPerCategory(String yearMonth, int dayOfEntry, ExpenseCategory category,Long userId);

    @Query("SELECT expense.amount FROM Expenses expense WHERE expense.dateOfExpense=:yearMonth AND expense.dayOfTheMonth=:dayOfEntry AND expense.category=:category AND expense.userId=:userId")
    List<Double> getAmountsAsPerDayAndCategory(String yearMonth, int dayOfEntry, ExpenseCategory category,Long userId);

    @Query("SELECT expense FROM Expenses expense WHERE expense.userId=:id")
    List<Expenses> getExpenseByUserId(Long id);

    @Query("SELECT e FROM Expenses e WHERE e.userId=:userId AND e.date BETWEEN:startDayOfMonth AND :endDayOfMonth" )
    List<Expenses> findReportsAfterDate( String startDayOfMonth, Long userId, String endDayOfMonth);

}
