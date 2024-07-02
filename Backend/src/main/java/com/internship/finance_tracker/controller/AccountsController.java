package com.internship.finance_tracker.controller;

import com.internship.finance_tracker.entity.Accounts;
import com.internship.finance_tracker.entity.IncomeAllocation;
import com.internship.finance_tracker.service.AccountsServiceImpl;
import com.internship.finance_tracker.service.IncomeAllocationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountsController {

    private final AccountsServiceImpl accountsService;

    @GetMapping("/addDetails/{entryDate}")
    private ResponseEntity<?> addIncomeAllocation(@PathVariable YearMonth entryDate){
       Accounts createAccounts = accountsService.addAccountsDetails(entryDate);
        if(createAccounts!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createAccounts);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
