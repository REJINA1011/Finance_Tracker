package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.service.IncomeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {


    private final IncomeServiceImpl incomeService;

    @PostMapping("/addIncomeDetails")
    private ResponseEntity<?> addIncome(@RequestBody IncomeDTO incomeDTO){
        Income createIncome = incomeService.addIncome(incomeDTO);

        if(createIncome!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createIncome);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
