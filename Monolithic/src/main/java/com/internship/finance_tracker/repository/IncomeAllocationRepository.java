package com.internship.finance_tracker.repository;

import com.internship.finance_tracker.entity.IncomeAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface IncomeAllocationRepository extends JpaRepository<IncomeAllocation,Long> {
   @Query("SELECT incomeAllocation FROM IncomeAllocation incomeAllocation where incomeAllocation.dateOfEntry=:date")
   IncomeAllocation getAllAmount(YearMonth date);
}
