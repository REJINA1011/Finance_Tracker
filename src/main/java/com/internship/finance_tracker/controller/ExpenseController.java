package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.dto.ExpenseDTO;
import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.entity.Expenses;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.service.ExpenseService;
import com.internship.finance_tracker.service.ExpenseServiceImpl;
import com.internship.finance_tracker.service.IncomeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {


    private final ExpenseServiceImpl expenseServiceImpl;

    @PostMapping("/addExpenseDetails")
    private ResponseEntity<?> addExpenses(@RequestBody ExpenseDTO expenseDTO){
       Expenses createExpense = expenseServiceImpl.addExpenses(expenseDTO);

        if(createExpense!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createExpense);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
