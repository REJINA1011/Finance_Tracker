package com.internship.user_expense.controller;

import com.internship.user_expense.dto.ExpenseDTO;
import com.internship.user_expense.entity.ApiResponse;
import com.internship.user_expense.entity.ExpenseCategory;
import com.internship.user_expense.entity.Expenses;
import com.internship.user_expense.service.ExpenseServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@CrossOrigin("*")
@EnableDiscoveryClient
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

    @GetMapping("/getAllExpenses")
    private ResponseEntity<ApiResponse> getAllListedExpenses(){
        List<Expenses> expensesList = expenseServiceImpl.getAllAddedExpense();

        if(expensesList!=null){
            ApiResponse response= ApiResponse.builder().message("List of total expenses").data(expensesList).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of expenses Found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //get all expenses for the given month
    @GetMapping("/getAllExpenses/{monthOfExpenseEntered}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable YearMonth monthOfExpenseEntered) {
        List<Expenses> expenses= expenseServiceImpl.getExpenseByDate(monthOfExpenseEntered);

        if(expenses!=null){
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(expenses).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of Expenses on the given month found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //get all the expenses as per date i.e. year, month and year
    @GetMapping("/getAllExpenses/{monthOfExpenseEntered}/{dayOfExpenseEntered}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable YearMonth monthOfExpenseEntered, @PathVariable int dayOfExpenseEntered) {
        List<Expenses> dayOfExpenses= expenseServiceImpl.getExpenseByDay(monthOfExpenseEntered,dayOfExpenseEntered);

        if(dayOfExpenses!=null){
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given date").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of Expenses on the given date found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllExpensesAmount/{yearMonth}/{category}")
    private List<Double> getAllExpensesAsCategory(@PathVariable YearMonth yearMonth, @PathVariable ExpenseCategory category){
        return expenseServiceImpl.getAllExpensesByCategory(yearMonth, category);
    }
}
