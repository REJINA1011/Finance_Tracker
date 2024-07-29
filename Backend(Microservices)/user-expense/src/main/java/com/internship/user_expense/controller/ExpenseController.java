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
@CrossOrigin(origins = "http://localhost:4200")
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

        if(expensesList.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No List of expenses Found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of total expenses").data(expensesList).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get all expenses for the given month
    @GetMapping("/getAllExpenses/{monthOfExpenseEntered}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable String monthOfExpenseEntered) {
        List<Expenses> expenses= expenseServiceImpl.getExpenseByDate(monthOfExpenseEntered);
        if(expenses.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No Entry done currently").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(expenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get all the expenses as per date i.e. year, month and day
    @GetMapping("/getAllExpenses/{monthOfExpenseEntered}/{dayOfExpenseEntered}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable String monthOfExpenseEntered, @PathVariable int dayOfExpenseEntered) {
        List<Expenses> dayOfExpenses= expenseServiceImpl.getExpenseByDay(monthOfExpenseEntered,dayOfExpenseEntered);

        if(dayOfExpenses.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No entry done currently").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given date").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllExpensesAmount/{yearMonth}/{category}")
    private double getAllExpensesAsCategory(@PathVariable String yearMonth, @PathVariable ExpenseCategory category){
        return expenseServiceImpl.getAllExpensesByCategory(yearMonth, category);
    }

    @GetMapping("/getAllExpensesAmount/{yearMonth}/{dayOfEntry}/{category}")
    private double getAllExpensesPerDayAsCategory(@PathVariable String yearMonth,@PathVariable int dayOfEntry, @PathVariable ExpenseCategory category){
        return expenseServiceImpl.getAllExpensesPerDayByCategory(yearMonth,dayOfEntry,category);
    }

    @GetMapping("/getAllExpenses/{yearMonth}/{dayOfEntry}/{category}")
    private ResponseEntity<ApiResponse> getAllExpensesEachDayAsCategory(@PathVariable String yearMonth,@PathVariable int dayOfEntry,@PathVariable ExpenseCategory category){
        List<Expenses> dayOfExpenses=  expenseServiceImpl.getAllExpensesEachDayByCategory(yearMonth,dayOfEntry,category);

        if(dayOfExpenses.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No entry done currently").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given date and category").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

}
