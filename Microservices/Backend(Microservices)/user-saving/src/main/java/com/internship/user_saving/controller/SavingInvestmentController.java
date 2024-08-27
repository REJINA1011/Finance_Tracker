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
@CrossOrigin(origins = "http://localhost:4200")
public class SavingInvestmentController {

    private final SavingInvestmentImpl savingInvestment;

    @PostMapping("/addSavingDetails/{userId}")
    private ResponseEntity<?> addSavings(@RequestBody SavingAndInvestmentDTO savingAndInvestmentDTO,@PathVariable Long userId){
        SavingAndInvestment createsavingAndInvestment = savingInvestment.addSavingInvestment(savingAndInvestmentDTO,userId);

        if(createsavingAndInvestment!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createsavingAndInvestment);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAllSavings")
    private ResponseEntity<ApiResponse> getAllListedSavings(){
        List<SavingAndInvestment> savingsList = savingInvestment.getAllAddedSavings();

        if(savingsList.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No entries currently made").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of total saving").data(savingsList).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get all Savings for the given month
    @GetMapping("/getSavings/{monthOfSavingsEntered}/{userId}")
    private ResponseEntity<ApiResponse> getSavingsByDate(@PathVariable String monthOfSavingsEntered,@PathVariable Long userId) {
        List<SavingAndInvestment> savings= savingInvestment.getSavingsByDate(monthOfSavingsEntered,userId);

        if(savings.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No entries currently made").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Expenses on the given month").data(savings).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get all the savings as per date i.e. year, month and year
    @GetMapping("/getAllSavings/{monthOfSavingsEntered}/{dayOfSavingsEntered}")
    private ResponseEntity<ApiResponse> getSavingsByDate(@PathVariable String monthOfSavingsEntered, @PathVariable int dayOfSavingsEntered) {

        List<SavingAndInvestment> dayOfSavings= savingInvestment.getSavingsByDay(monthOfSavingsEntered,dayOfSavingsEntered);

        if(dayOfSavings.isEmpty()){
            ApiResponse response= ApiResponse.builder().message("No entries currently").data(null).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response= ApiResponse.builder().message("List of Savings on the given month").data(dayOfSavings).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get total of the given month
    @GetMapping("/getSavingAmounts/{dateOfEntry}/{userId}")
    private double getSavingsAmount(@PathVariable String dateOfEntry,@PathVariable Long userId){
        return savingInvestment.getSavingsAmount(dateOfEntry,userId);
    }

    //get total savings of the current day
    @GetMapping("/getSavingAmount/{dateOfEntry}/{dayOfMonth}/{userId}")
    private double getSavingsAmountCurrentDay(@PathVariable String dateOfEntry,@PathVariable String dayOfMonth,@PathVariable Long userId){
        return savingInvestment.getSavingsAmountCurrentDay(dateOfEntry,dayOfMonth,userId);
    }

    @GetMapping("/reports/{userId}/{days}")
    public List<SavingAndInvestment> getReports(@PathVariable int days,@PathVariable Long userId) {
        return savingInvestment.getReports(days,userId);
    }
}
