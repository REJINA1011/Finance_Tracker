package com.internship.user_income.repository;

import com.internship.user_income.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {


    @Query("SELECT income.amount FROM Income income where income.dateOfEntry=:date AND income.userId=:userId")
    List<Double> getAllIncomeAmount(String date,Long userId);

    @Query("SELECT income FROM Income income where income.dateOfEntry=:dateOfIncomeEntered AND income.userId=:userId")
    List<Income> findByDate(String dateOfIncomeEntered,Long userId);

    @Query("SELECT i FROM Income i WHERE i.userId=:userId AND i.date BETWEEN:startDate AND :endDayOfMonth")
    List<Income> findReportsAfterDate(String startDate, Long userId, String endDayOfMonth);
}
