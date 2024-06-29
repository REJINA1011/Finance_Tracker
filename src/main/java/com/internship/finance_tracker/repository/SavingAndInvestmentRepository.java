package com.internship.finance_tracker.repository;

import com.internship.finance_tracker.entity.SavingAndInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface SavingAndInvestmentRepository extends JpaRepository<SavingAndInvestment,Long> {
    @Query("SELECT saving.amount FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:date")
    List<Double> getSavingAmounts(YearMonth date);
}
