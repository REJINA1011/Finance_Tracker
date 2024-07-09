package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.dto.IncomeAllocationDTO;

import com.internship.finance_tracker.entity.IncomeAllocation;

import com.internship.finance_tracker.service.IncomeAllocationServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;

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

}
