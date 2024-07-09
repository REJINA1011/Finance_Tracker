package com.internship.user_income_allocation.controller;

import com.internship.user_income_allocation.dto.IncomeAllocationDTO;

import com.internship.user_income_allocation.entity.IncomeAllocation;

import com.internship.user_income_allocation.service.IncomeAllocationServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/incomeAllocator")
@RequiredArgsConstructor
@CrossOrigin("*")

public class IncomeAllocationController {

    private final IncomeAllocationServiceImpl allocationService;

    @GetMapping("/addDetails/{incomeEntryDate}")
    private ResponseEntity<?> addIncomeAllocation( @PathVariable YearMonth incomeEntryDate){
        IncomeAllocation createIncomeAllocationDTO = allocationService.addIncomeAllocationDetails(incomeEntryDate);

        if(createIncomeAllocationDTO!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createIncomeAllocationDTO);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAllIncomeAllocations/{dateOfEntry}")
    private IncomeAllocation getAllIncomeAllocations(@PathVariable YearMonth dateOfEntry){
        return allocationService.getIncomeAllocations(dateOfEntry);
    }

}
