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

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addExpenseDetails/{email}")
    private ResponseEntity<?> addExpenses(@RequestBody ExpenseDTO expenseDTO,@PathVariable String email){
       Expenses createExpense = expenseServiceImpl.addExpenses(expenseDTO,email);

        if(createExpense!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createExpense);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAllExpensesByUserId/{id}")
    private ResponseEntity<ApiResponse> getAllListedExpenses(@PathVariable("id")Long id){
        List<Expenses> expenses= expenseServiceImpl.getAllExpensesByUserId(id);
        if(expenses.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No Entry done currently").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(expenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get all expenses for the given month
    @GetMapping("/getAllExpenses/{monthOfExpenseEntered}/{userId}")
    private ResponseEntity<ApiResponse> getExpenseByDate(@PathVariable String monthOfExpenseEntered,@PathVariable Long userId) {
        List<Expenses> expenses= expenseServiceImpl.getExpenseByDate(monthOfExpenseEntered,userId);
        if(expenses.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No Entry done currently").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(expenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get all the expenses as per date i.e. year, month and day
    @GetMapping("/getExpenses/{monthOfExpenseEntered}/{dayOfExpenseEntered}")
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

    @GetMapping("/getAllExpensesAmount/{yearMonth}/{category}/{userId}")
    private double getAllExpensesAsCategory(@PathVariable String yearMonth, @PathVariable ExpenseCategory category,@PathVariable Long userId){
        return expenseServiceImpl.getAllExpensesByCategory(yearMonth, category,userId);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllExpensesAmount/{yearMonth}/{dayOfEntry}/{category}/{userId}")
    private double getAllExpensesPerDayAsCategory(@PathVariable String yearMonth,@PathVariable int dayOfEntry, @PathVariable ExpenseCategory category,@PathVariable Long userId){
        return expenseServiceImpl.getAllExpensesPerDayByCategory(yearMonth,dayOfEntry,category,userId);
    }

    @GetMapping("/getAllExpenses/{yearMonth}/{dayOfEntry}/{category}/{userId}")
    private ResponseEntity<ApiResponse> getAllExpensesEachDayAsCategory(@PathVariable String yearMonth,@PathVariable int dayOfEntry,@PathVariable ExpenseCategory category,@PathVariable Long userId){
        List<Expenses> dayOfExpenses=  expenseServiceImpl.getAllExpensesEachDayByCategory(yearMonth,dayOfEntry,category,userId);

        if(dayOfExpenses.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No entry done currently").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given date and category").data(dayOfExpenses).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    //for report Filtering(7days, 15days, 30Days)
//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/reports/{userId}/{days}")
    public List<Expenses> getReports(@PathVariable int days,@PathVariable Long userId) {
        return expenseServiceImpl.getReports(days,userId);
    }

}
