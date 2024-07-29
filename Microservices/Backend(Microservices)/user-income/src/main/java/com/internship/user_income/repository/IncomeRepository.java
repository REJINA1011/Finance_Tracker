package com.internship.user_income.repository;

import com.internship.user_income.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {


    @Query("SELECT income.amount FROM Income income where income.dateOfEntry=:date")
    List<Double> getAllIncomeAmount(String date);

    @Query("SELECT income FROM Income income where income.dateOfEntry=:dateOfIncomeEntered")
    List<Income> findByDate(String dateOfIncomeEntered);
}
