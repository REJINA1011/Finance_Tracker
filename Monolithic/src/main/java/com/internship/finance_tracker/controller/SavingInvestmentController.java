package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.dto.SavingAndInvestmentDTO;
import com.internship.finance_tracker.entity.ApiResponse;
import com.internship.finance_tracker.entity.Expenses;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.entity.SavingAndInvestment;
import com.internship.finance_tracker.service.IncomeServiceImpl;
import com.internship.finance_tracker.service.SavingInvestmentImpl;
import com.internship.finance_tracker.service.SavingInvestmentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

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

    @GetMapping("/getAllExpenses")
    private ResponseEntity<ApiResponse> getAllListedExpenses(){
        List<SavingAndInvestment> expensesList = savingInvestment.getAllAddedSavings();

        if(expensesList!=null){
            ApiResponse response= ApiResponse.builder().message("List of total saving").data(expensesList).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of savings Found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //get all Savings for the given month
    @GetMapping("/getAllSavings/{monthOfSavingsEntered}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable YearMonth monthOfSavingsEntered) {
        List<SavingAndInvestment> savings= savingInvestment.getSavingsByDate(monthOfSavingsEntered);

        if(savings!=null){
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(savings).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of Expenses on the given month found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //get all the expenses as per date i.e. year, month and year
    @GetMapping("/getAllSavings/{monthOfSavingsEntered}/{dayOfSavingsEntered}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable YearMonth monthOfSavingsEntered, @PathVariable int dayOfSavingsEntered) {


        List<SavingAndInvestment> dayOfSavings= savingInvestment.getSavingsByDay(monthOfSavingsEntered,dayOfSavingsEntered);

        if(dayOfSavings!=null){
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(dayOfSavings).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of Expenses on the given month found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
