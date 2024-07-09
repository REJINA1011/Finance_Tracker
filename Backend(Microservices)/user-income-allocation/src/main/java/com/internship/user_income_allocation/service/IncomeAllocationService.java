package com.internship.user_income_allocation.service;

import com.internship.user_income_allocation.dto.IncomeAllocationDTO;
import com.internship.user_income_allocation.entity.IncomeAllocation;

import java.time.LocalDate;
import java.time.YearMonth;

public interface IncomeAllocationService {
    IncomeAllocation addIncomeAllocationDetails(YearMonth date);
}
