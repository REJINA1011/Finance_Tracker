package com.internship.user_income.controller;

import com.internship.user_income.dto.IncomeDTO;
import com.internship.user_income.entity.ApiResponse;
import com.internship.user_income.entity.Income;
import com.internship.user_income.service.IncomeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@EnableDiscoveryClient
public class IncomeController {

    @Autowired
    private IncomeServiceImpl incomeService;

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
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of income Found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllIncomes/{dateOfIncomeEntered}")
    private ResponseEntity<ApiResponse> getIncomeByDate(@PathVariable String dateOfIncomeEntered){
        List<Income> income = incomeService.getIncomesByDate(dateOfIncomeEntered);

        if(income!=null){
            ApiResponse response= ApiResponse.builder().message("Income on the given date").data(income).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("No Income on the given date found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/getIncomeAmount/{dateOfIncomeEntered}")
    private List<Double> getAllIncomeAmount(@PathVariable String dateOfIncomeEntered){
        return incomeService.getAllIncomeAmount(dateOfIncomeEntered);
    }

}
