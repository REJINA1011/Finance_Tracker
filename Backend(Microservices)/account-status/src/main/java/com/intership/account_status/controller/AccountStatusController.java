package com.intership.account_status.controller;

import com.intership.account_status.entity.AccountStatus;
import com.intership.account_status.entity.ResponseMessage;
import com.intership.account_status.services.AccountsStatusServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

@RestController
@RequestMapping("/api/accountStatus")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountStatusController {

    private AccountsStatusServiceImpl statusServiceImpl;

    @GetMapping("/addStatusDetails/{entryDate}")
    private ResponseEntity<?> addAccountStatus(@PathVariable YearMonth entryDate){
        AccountStatus addAccountStatus = statusServiceImpl.addDeviationDetails(entryDate);
        if(addAccountStatus!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(addAccountStatus);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
