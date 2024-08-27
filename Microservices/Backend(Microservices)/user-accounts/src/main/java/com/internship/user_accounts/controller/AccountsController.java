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
public class AccountsController {

    private final AccountsServiceImpl accountsService;

    @GetMapping("/addDetails/{entryDate}/{userId}")
    private ResponseEntity<?> addAccount(@PathVariable String entryDate,@PathVariable Long userId){
       Accounts createAccounts = accountsService.addAccountsDetails(entryDate,userId);
        if(createAccounts!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createAccounts);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAccountsDetails/{entryDate}")
    private Accounts getAccountsDetails(@PathVariable String entryDate){
        return accountsService.getAccountDetails(entryDate);
    }

}
