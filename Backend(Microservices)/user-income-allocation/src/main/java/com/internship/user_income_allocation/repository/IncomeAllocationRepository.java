package com.internship.user_income_allocation.repository;

import com.internship.user_income_allocation.dto.IncomeAllocationDTO;
import com.internship.user_income_allocation.entity.IncomeAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface IncomeAllocationRepository extends JpaRepository<IncomeAllocation,Long> {
   @Query("SELECT incomeAllocation FROM IncomeAllocation incomeAllocation where incomeAllocation.dateOfEntry=:yearMonth")
   IncomeAllocation getAllocationsByYearMonth(String yearMonth);
}
