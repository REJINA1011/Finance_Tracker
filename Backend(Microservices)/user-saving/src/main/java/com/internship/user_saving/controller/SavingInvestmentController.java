package com.internship.user_saving.controller;
import com.internship.user_saving.dto.SavingAndInvestmentDTO;
import com.internship.user_saving.entity.ApiResponse;
import com.internship.user_saving.entity.SavingAndInvestment;
import com.internship.user_saving.service.SavingInvestmentImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/saving")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SavingInvestmentController {

    private final SavingInvestmentImpl savingInvestment;

    @PostMapping("/addSavingDetails")
    private ResponseEntity<?> addSavings(@RequestBody SavingAndInvestmentDTO savingAndInvestmentDTO){
        SavingAndInvestment createsavingAndInvestment = savingInvestment.addSavingInvestment(savingAndInvestmentDTO);

        if(createsavingAndInvestment!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createsavingAndInvestment);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAllSavings")
    private ResponseEntity<ApiResponse> getAllListedSavings(){
        List<SavingAndInvestment> savingsList = savingInvestment.getAllAddedSavings();

        if(savingsList!=null){
            ApiResponse response= ApiResponse.builder().message("List of total saving").data(savingsList).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of savings Found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //get all Savings for the given month
    @GetMapping("/getAllSavings/{monthOfSavingsEntered}")
    private ResponseEntity<ApiResponse> getSavingsByDate(@PathVariable YearMonth monthOfSavingsEntered) {
        List<SavingAndInvestment> savings= savingInvestment.getSavingsByDate(monthOfSavingsEntered);

        if(savings!=null){
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(savings).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of Expenses on the given month found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //get all the savings as per date i.e. year, month and year
    @GetMapping("/getAllSavings/{monthOfSavingsEntered}/{dayOfSavingsEntered}")
    private ResponseEntity<ApiResponse> getSavingsByDate(@PathVariable YearMonth monthOfSavingsEntered, @PathVariable int dayOfSavingsEntered) {

        List<SavingAndInvestment> dayOfSavings= savingInvestment.getSavingsByDay(monthOfSavingsEntered,dayOfSavingsEntered);

        if(dayOfSavings!=null){
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(dayOfSavings).build();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            ApiResponse response= ApiResponse.builder().message("No List of Expenses on the given month found").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getSavingAmount/{dateOfEntry}")
    private List<Double> getSavingsAmount(@PathVariable YearMonth dateOfEntry){
        return savingInvestment.getSavingsAmount(dateOfEntry);
    }
}
