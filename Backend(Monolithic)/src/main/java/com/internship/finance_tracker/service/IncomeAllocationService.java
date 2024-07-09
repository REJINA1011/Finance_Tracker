package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.IncomeAllocationDTO;
import com.internship.finance_tracker.entity.IncomeAllocation;

import java.time.LocalDate;
import java.time.YearMonth;

public interface IncomeAllocationService {
    IncomeAllocation addIncomeAllocationDetails(YearMonth date);
}
