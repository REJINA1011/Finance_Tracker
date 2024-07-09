package com.intership.account_status.dto;

import com.intership.account_status.entity.AccountCategory;
import com.intership.account_status.entity.AccountDeviationDes;
import com.intership.account_status.entity.AccountStatus;
import lombok.Data;

@Data
public class AccountStatusDTO {

    private Long accountStatusId;

    private long accountId;

    private double deviationAmount;

    private AccountCategory accountCategory;

    private AccountDeviationDes accountStatus;

    public AccountStatus getAccountsDto(){
       AccountStatus accountStatusDTO = new AccountStatus();

       accountStatusDTO.setAccountId(accountId);
       accountStatusDTO.setAccountStatusId(accountStatusId);
       accountStatusDTO.setDeviationAmount(deviationAmount);
       accountStatusDTO.setAccountStatus(accountStatus);
       accountStatusDTO.setAccountCategory(accountCategory);

        return accountStatusDTO;
    }
}
