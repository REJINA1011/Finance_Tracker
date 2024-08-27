package com.internship.user_accounts.dto;

import lombok.Data;

import java.time.YearMonth;

@Data
public class AccountsDTO {

    private Long accountId;

    private String date;

    private double income;

    private double spentOnNeeds;
    private double allocatedNeeds;
    private double spentOnWants;
    private double allocatedWants;
    private double spendOnSavings;
    private double allocatedSavings;

    private Long userId;
    public AccountsDTO getAccountsDto(){
        AccountsDTO accountsDTO = new AccountsDTO();

        accountsDTO.setAccountId(accountId);
        accountsDTO.setDate(date);
        accountsDTO.setIncome(income);
        accountsDTO.setSpentOnNeeds(spentOnNeeds);
        accountsDTO.setAllocatedNeeds(allocatedNeeds);
        accountsDTO.setSpentOnWants(spentOnWants);
        accountsDTO.setAllocatedWants(allocatedWants);
        accountsDTO.setSpendOnSavings(spendOnSavings);
        accountsDTO.setSpendOnSavings(spendOnSavings);
        accountsDTO.setUserId(userId);


        return accountsDTO;
    }
}
