package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.AccountsDTO;
import com.internship.finance_tracker.dto.IncomeAllocationDTO;
import com.internship.finance_tracker.entity.Accounts;
import com.internship.finance_tracker.entity.ExpenseCategory;
import com.internship.finance_tracker.entity.IncomeAllocation;
import com.internship.finance_tracker.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountServices{

    private final IncomeAllocationRepository incomeAllocationRepository;

    private final ExpenseRepository expenseRepository;

    private final SavingAndInvestmentRepository savingAndInvestmentRepository;

    private final AccountsRepository accountsRepository;

    private Accounts addAccounts(YearMonth date, Accounts accounts){

        AccountsDTO accountsDTO=new AccountsDTO();

        accounts.setAccountId(accountsDTO.getAccountId());
        accounts.setDate(date);

        //to get allocated income, expenses and saving amount
        IncomeAllocation amounts=incomeAllocationRepository.getAllAmount(date);

        accounts.setIncome(amounts.getIncomeAmount());
        accounts.setAllocatedNeeds(amounts.getExpensesOnNeeds());
        accounts.setAllocatedWants(amounts.getExpensesOnWants());
        accounts.setAllocatedSavings(amounts.getSavingAmount());

        //to get list of expenses amount
        List<Double> spentOnNeedsList=expenseRepository.getAmountsAsPerCategory(date, ExpenseCategory.NEEDS);
        List<Double> spentOnWantsList=expenseRepository.getAmountsAsPerCategory(date, ExpenseCategory.WANTS);


        List<Double> spentOnSavingList=savingAndInvestmentRepository.getSavingAmounts(date);

        accounts.setSpentOnNeeds(totalExpenseMade(spentOnNeedsList));
        accounts.setSpentOnWants(totalExpenseMade(spentOnWantsList));
        accounts.setSpendOnSavings(totalExpenseMade(spentOnSavingList));

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

}
