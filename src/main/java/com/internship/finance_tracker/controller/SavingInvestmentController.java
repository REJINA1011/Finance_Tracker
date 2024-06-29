package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.dto.SavingAndInvestmentDTO;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.entity.SavingAndInvestment;
import com.internship.finance_tracker.service.IncomeServiceImpl;
import com.internship.finance_tracker.service.SavingInvestmentImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saving")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SavingInvestmentController {

    private final SavingInvestmentImpl savingInvestment;

    @PostMapping("/addSavingDetails")
    private ResponseEntity<?> addIncome(@RequestBody SavingAndInvestmentDTO savingAndInvestmentDTO){
        SavingAndInvestment createsavingAndInvestment = savingInvestment.addSavingInvestment(savingAndInvestmentDTO);

        if(createsavingAndInvestment!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createsavingAndInvestment);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
