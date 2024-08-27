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
    @Autowired
    private RestTemplate restTemplate;

    private final AccountsRepository accountsRepository;

    private Accounts addAccounts(String date, Accounts accounts,Long userId){

        //to get allocated income, expenses and saving amount

        IncomeAllocations incomeAmountDetails = restTemplate.getForObject("http://user-income-allocation/api/incomeAllocator/getAllIncomeAllocations/"+date+"/"+userId, IncomeAllocations.class );

        if(incomeAmountDetails==null){
            throw new DataNotFoundException("Data is not found");
        }

        double spentOnNeedsList=restTemplate.getForObject("http://user-expense/api/expenses/getAllExpensesAmount/"+date+"/"+ExpenseCategory.NEEDS+"/"+userId, Double.class);
        System.out.println("accounts needs:"+spentOnNeedsList);
        double spentOnWantsList=restTemplate.getForObject("http://user-expense/api/expenses/getAllExpensesAmount/"+date+"/"+ExpenseCategory.WANTS+"/"+userId, Double.class);

        double spentOnSavingsList=restTemplate.getForObject("http://user-saving/api/saving/getSavingAmounts/"+date+"/"+userId, Double.class);

        Accounts accountsObj =accountsRepository.getAllAccounts(date);
        if(accountsObj!=null){
            accountsObj.setIncome(incomeAmountDetails.getIncomeAmount());
            accountsObj.setAllocatedNeeds(incomeAmountDetails.getExpensesOnNeeds());
            accountsObj.setAllocatedWants(incomeAmountDetails.getExpensesOnWants());
            accountsObj.setAllocatedSavings(incomeAmountDetails.getSavingAmount());
            accountsObj.setSpentOnNeeds(spentOnNeedsList);
            accountsObj.setSpentOnWants(spentOnWantsList);
            accountsObj.setSpendOnSavings(spentOnSavingsList);
            accountsObj.setUserId(userId);

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
        accounts.setSpentOnNeeds(spentOnNeedsList);
        accounts.setSpentOnWants(spentOnWantsList);
        accounts.setSpendOnSavings(spentOnSavingsList);
        accounts.setUserId(userId);
        return accountsRepository.save(accounts);
    }

    public Accounts addAccountsDetails(String date,Long userId) {
        return addAccounts(date,new Accounts(),userId);
    }

    public Accounts getAccountDetails(String entryDate) {
        return accountsRepository.getAllAccounts(entryDate);
    }
}
