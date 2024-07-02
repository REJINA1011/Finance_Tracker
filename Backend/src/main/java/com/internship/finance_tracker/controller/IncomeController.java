package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.entity.ApiResponse;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.service.IncomeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

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
    @GetMapping("/getAllIncomes")
    private ResponseEntity<ApiResponse> getAllListedIncomes(){
        List<Income> incomeList = incomeService.getAllAddedIncomes();

        if(incomeList!=null){
            ApiResponse response= ApiResponse.builder().message("List of income").data(incomeList).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of income Found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllIncomes/{dateOfIncomeEntered}")
    private ResponseEntity<ApiResponse> getIncomeByDate(@PathVariable YearMonth dateOfIncomeEntered){
        List<Income> income = incomeService.getIncomesByDate(dateOfIncomeEntered);

        if(income!=null){
            ApiResponse response= ApiResponse.builder().message("Income on the given date").data(income).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No Income on the given date found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
