package com.internship.user_income_allocation.controller;

import com.internship.user_income_allocation.entity.ApiResponse;
import com.internship.user_income_allocation.entity.IncomeAllocation;

import com.internship.user_income_allocation.service.IncomeAllocationServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomeAllocator")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class IncomeAllocationController {

    private final IncomeAllocationServiceImpl allocationService;

    @GetMapping("/addDetails/{incomeEntryDate}/{userId}")
    private ResponseEntity<?> addIncomeAllocation( @PathVariable String incomeEntryDate,@PathVariable Long userId){
        IncomeAllocation createIncomeAllocationDTO = allocationService.addIncomeAllocationDetails(incomeEntryDate,userId);

        if(createIncomeAllocationDTO!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createIncomeAllocationDTO);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAllIncomeAllocations")
    private List<IncomeAllocation> getAllIncomeAllocations(){
        return allocationService.getIncomeAllocations();
    }
    @GetMapping("/getAllIncomeAllocations/{yearMonth}/{userId}")
    private IncomeAllocation getIncomeAllocationsByDate(@PathVariable String yearMonth,@PathVariable Long userId){
        return allocationService.getIncomeAllocationsByYearMonth(yearMonth,userId);
    }
}
