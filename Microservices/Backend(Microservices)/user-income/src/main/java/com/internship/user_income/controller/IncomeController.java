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
//@CrossOrigin(origins = )
@CrossOrigin(
        origins = {
                "http://localhost:4200"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@EnableDiscoveryClient
public class IncomeController {

    @Autowired
    private IncomeServiceImpl incomeService;

    @PostMapping("/addIncomeDetails/{userId}")
    private ResponseEntity<?> addIncome(@RequestBody IncomeDTO incomeDTO,@PathVariable Long userId){

        Income createIncome = incomeService.addIncome(incomeDTO,userId);

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

    @GetMapping("/getAllIncomes/{dateOfIncomeEntered}/{userId}")
    private ResponseEntity<ApiResponse> getIncomeByDate(@PathVariable String dateOfIncomeEntered,@PathVariable Long userId ){
        List<Income> income = incomeService.getIncomesByDate(dateOfIncomeEntered,userId);

        if(income!=null){
            ApiResponse response= ApiResponse.builder().message("Income on the given date").data(income).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("No Income on the given date found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/getIncomeAmount/{dateOfIncomeEntered}/{userId}")
    private List<Double> getAllIncomeAmount(@PathVariable String dateOfIncomeEntered,@PathVariable Long userId){
        return incomeService.getAllIncomeAmount(dateOfIncomeEntered,userId);
    }

    @GetMapping("/reports/{userId}/{days}")
    public List<Income> getReports(@PathVariable int days,@PathVariable Long userId) {
        return incomeService.getReports(days,userId);
    }

}
