package com.internship.user_income_allocation.service;

import com.internship.user_income_allocation.dto.IncomeAllocationDTO;
import com.internship.user_income_allocation.entity.ApiResponse;
import com.internship.user_income_allocation.entity.IncomeAllocation;
import com.internship.user_income_allocation.exception.TableEmptyException;
import com.internship.user_income_allocation.repository.IncomeAllocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeAllocationServiceImpl implements IncomeAllocationService {

    private final IncomeAllocationRepository incomeAllocationRepository;

    @Autowired
    private RestTemplate restTemplate;

    private IncomeAllocation addIncomeAllocations(YearMonth date,IncomeAllocation incomeAllocation){

        List<Double> incomeAmountList=restTemplate.getForObject("http://user-income/api/income/getIncomeAmount/"+date, ArrayList.class);

        if(incomeAmountList.isEmpty()){
            throw new TableEmptyException("Income Amount is not entered.");
        }

        double totalincomeAmount=0;
        for(Double incomeamount:incomeAmountList){
            totalincomeAmount+=incomeamount;
        }

        //update value in the database if the income allocation is already made on that date
        IncomeAllocation incomeAllocationObj =incomeAllocationRepository.getAllAmount(date);

        if(incomeAllocationObj!=null){

                incomeAllocationObj.setIncomeAmount(totalincomeAmount);
                incomeAllocationObj.setExpensesOnNeeds(expensesAndSavingAllocator(totalincomeAmount,"needs"));
                incomeAllocationObj.setExpensesOnWants(expensesAndSavingAllocator(totalincomeAmount,"wants"));
                incomeAllocationObj.setSavingAmount(expensesAndSavingAllocator(totalincomeAmount,"saving"));

                return incomeAllocationRepository.save(incomeAllocationObj);
        }

        IncomeAllocationDTO incomeAllocationDTO=new IncomeAllocationDTO();

        incomeAllocation.setIncomeAllocationId(incomeAllocationDTO.getIncomeAllocationId());

        incomeAllocation.setDateOfEntry(incomeAllocationDTO.getDateOfEntry());

//        List<Double> incomeAmountList=restTemplate.getForObject("http://user-income/api/income/getIncomeAmount/"+date, ArrayList.class);
//


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

    public IncomeAllocation getIncomeAllocations(YearMonth yearMonth) {
        return incomeAllocationRepository.getAllAmount(yearMonth);
    }
}
