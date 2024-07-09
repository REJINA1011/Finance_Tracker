package com.internship.user_accounts.controller;

import com.internship.user_accounts.entity.Accounts;
import com.internship.user_accounts.service.AccountsServiceImpl;

import lombok.Getter;
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
    private ResponseEntity<?> addAccount(@PathVariable YearMonth entryDate){
       Accounts createAccounts = accountsService.addAccountsDetails(entryDate);
        if(createAccounts!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createAccounts);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAccountsDetails/{entryDate}")
    private Accounts getAccountsDetails(@PathVariable YearMonth entryDate){
        return accountsService.getAccountDetails(entryDate);
    }

}
