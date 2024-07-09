package com.internship.user_accounts.service;

import com.internship.user_accounts.dto.AccountsDTO;
import com.internship.user_accounts.entity.*;

import com.internship.user_accounts.exception.DataNotFoundException;
import com.internship.user_accounts.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class  AccountsServiceImpl implements AccountServices{
    //@Autowired
    private RestTemplate restTemplate;

    private final AccountsRepository accountsRepository;

    private Accounts addAccounts(YearMonth date, Accounts accounts){

        //to get allocated income, expenses and saving amount

        IncomeAllocations incomeAmountDetails = restTemplate.getForObject("http://user-income-allocation/api/incomeAllocator/getAllIncomeAllocations/"+date, IncomeAllocations.class );

        if(incomeAmountDetails==null){
            throw new DataNotFoundException("Data is not found");
        }

        List<Double> spentOnNeedsList=restTemplate.getForObject("http://user-expense/api/expenses/getAllExpensesAmount/"+date+"/"+ExpenseCategory.NEEDS, ArrayList.class);

        List<Double> spentOnWantsList=restTemplate.getForObject("http://user-expense/api/expenses/getAllExpensesAmount/"+date+"/"+ExpenseCategory.WANTS, ArrayList.class);

        List<Double> spentOnSavingsList=restTemplate.getForObject("http://user-saving/api/saving/getSavingAmount/"+date, ArrayList.class);

        Accounts accountsObj =accountsRepository.getAllAccounts(date);

        if(accountsObj!=null){
            accountsObj.setIncome(incomeAmountDetails.getIncomeAmount());
            accounts.setAllocatedNeeds(incomeAmountDetails.getExpensesOnNeeds());
            accounts.setAllocatedWants(incomeAmountDetails.getExpensesOnWants());
            accounts.setAllocatedSavings(incomeAmountDetails.getSavingAmount());
            accounts.setSpentOnNeeds(totalExpenseMade(spentOnNeedsList));
            accounts.setSpentOnWants(totalExpenseMade(spentOnWantsList));
            accounts.setSpendOnSavings(totalExpenseMade(spentOnSavingsList));

            return accountsRepository.save(accountsObj);
        }

        AccountsDTO accountsDTO=new AccountsDTO();

        accounts.setAccountId(accountsDTO.getAccountId());
        accounts.setDate(date);
        accounts.setIncome(incomeAmountDetails.getIncomeAmount());

        //setting the amounts allocated
        accounts.setAllocatedNeeds(incomeAmountDetails.getExpensesOnNeeds());
        accounts.setAllocatedWants(incomeAmountDetails.getExpensesOnWants());
        accounts.setAllocatedSavings(incomeAmountDetails.getSavingAmount());

        //setting the amounts spent by the user
        accounts.setSpentOnNeeds(totalExpenseMade(spentOnNeedsList));
        accounts.setSpentOnWants(totalExpenseMade(spentOnWantsList));
        accounts.setSpendOnSavings(totalExpenseMade(spentOnSavingsList));

//        //setting the deviation found between the amount spent by the user and the amount allocated
//        double deviationAmount=getAmountDeviation(totalExpenseMade(spentOnNeedsList),incomeAmountDetails.getExpensesOnNeeds());
//
//        accounts.setNeedsDeviation(deviationAmount);
//        accounts.setAccountStatus(setDeviationStatus(deviationAmount));
//
//        accounts.setWantsDeviation(deviationAmount);
//        accounts.setAccountStatus(setDeviationStatus(deviationAmount));
//
//        accounts.setSavingsDeviation(deviationAmount);
//


        return accountsRepository.save(accounts);
    }

    public Accounts addAccountsDetails(YearMonth date) {
        return addAccounts(date,new Accounts());
    }

    private double totalExpenseMade(List<Double> expenseAmountList){
        double totalAmount=0;

        for(Double expenseAmount:expenseAmountList){
            totalAmount+=expenseAmount;
        }
        return totalAmount;
    }

    public Accounts getAccountDetails(YearMonth entryDate) {
        return accountsRepository.getAllAccounts(entryDate);
    }

//    private double getAmountDeviation(double userTotalAmounts, double allocatedAmounts){
//        return allocatedAmounts-userTotalAmounts;
//    }
//
//
}
