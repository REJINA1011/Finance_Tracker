package com.internship.finance_tracker.repository;

import com.internship.finance_tracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {


    @Query("SELECT income.amount FROM Income income where income.dateOfEntry=:date")
    List<Double> getAllIncomeAmount(YearMonth date);
}
