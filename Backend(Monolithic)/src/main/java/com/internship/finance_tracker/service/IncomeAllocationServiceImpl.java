package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.ExpenseDTO;
import com.internship.finance_tracker.dto.IncomeAllocationDTO;
import com.internship.finance_tracker.entity.ExpenseCategory;
import com.internship.finance_tracker.entity.Expenses;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.entity.IncomeAllocation;
import com.internship.finance_tracker.repository.ExpenseRepository;
import com.internship.finance_tracker.repository.IncomeAllocationRepository;
import com.internship.finance_tracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeAllocationServiceImpl implements IncomeAllocationService {

    private final IncomeAllocationRepository incomeAllocationRepository;
    private final IncomeRepository incomeRepository;

    private IncomeAllocation addIncomeAllocations(YearMonth date,IncomeAllocation incomeAllocation){
        IncomeAllocationDTO incomeAllocationDTO=new IncomeAllocationDTO();
        incomeAllocation.setIncomeAllocationId(incomeAllocationDTO.getIncomeAllocationId());
        incomeAllocation.setDateOfEntry(incomeAllocationDTO.getDateOfEntry());

        List<Double> incomeAmountList=incomeRepository.getAllIncomeAmount(date);
        double totalincomeAmount=0;
        for(Double incomeamount:incomeAmountList){
            totalincomeAmount+=incomeamount;
        }

        incomeAllocation.setIncomeAmount(totalincomeAmount);
        incomeAllocation.setExpensesOnNeeds(expensesAndSavingAllocator(totalincomeAmount,"needs"));
        incomeAllocation.setExpensesOnWants(expensesAndSavingAllocator(totalincomeAmount,"wants"));
        incomeAllocation.setSavingAmount(expensesAndSavingAllocator(totalincomeAmount,"saving"));

        return incomeAllocationRepository.save(incomeAllocation);
    }

    public IncomeAllocation addIncomeAllocationDetails(YearMonth date) {
        return addIncomeAllocations(date,new IncomeAllocation());
    }

    private double expensesAndSavingAllocator(double incomeAmount, String category){
        double allocationAmount=0;
        if(category.equalsIgnoreCase("needs")){
           allocationAmount=incomeAmount*0.5;
        } else if (category.equalsIgnoreCase("wants")) {
            allocationAmount=incomeAmount*0.3;
        } else if (category.equalsIgnoreCase("saving")) {
            allocationAmount=incomeAmount*0.2;
        }
        return allocationAmount;
    }
}
