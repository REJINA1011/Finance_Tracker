package com.intership.account_status.services;

import com.intership.account_status.dto.AccountStatusDTO;
import com.intership.account_status.entity.AccountDeviationDes;
import com.intership.account_status.entity.AccountStatus;
import com.intership.account_status.entity.Accounts;
import com.intership.account_status.entity.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.YearMonth;

@Service
@RequiredArgsConstructor
public class AccountsStatusServiceImpl implements AccountStatusServices{

    private RestTemplate restTemplate;

    public AccountStatus addDeviationDetails(YearMonth dateOfEntry) {
        return addAccountStatus(dateOfEntry,new AccountStatus());
    }

    private AccountStatus addAccountStatus(YearMonth dateOfEntry, AccountStatus accountStatus) {
        double deviationNeedsAmount=0;
        double deviationWantsAmount=0;
        double deviationSavingsAmount=0;
        //get the accountId on the provided date
        Accounts accountsDetails= restTemplate.getForObject("http://user-accounts/api/accounts/getAccountsDetails/"+dateOfEntry,Accounts.class);

        AccountStatusDTO accountStatusDTO = new AccountStatusDTO();

        accountStatus.setAccountStatusId(accountStatusDTO.getAccountStatusId());
        accountStatus.setAccountId(accountsDetails.getAccountId());

        double allocatedNeeds=accountsDetails.getAllocatedNeeds();
        double userNeedsExpenses=accountsDetails.getSpentOnNeeds();
        deviationNeedsAmount=getAmountDeviation(userNeedsExpenses,allocatedNeeds);

        double allocatedWants=accountsDetails.getAllocatedWants();
        double userWantsExpenses=accountsDetails.getSpentOnWants();
        deviationWantsAmount=getAmountDeviation(userWantsExpenses,allocatedWants);

        double allocatedSavings=accountsDetails.getAllocatedSavings();
        double userSavings=accountsDetails.getSpendOnSavings();
        deviationSavingsAmount=getAmountDeviation(userSavings,allocatedSavings);

        accountStatus.setDeviationAmount(setDeviationStatus(););


    }

    private double getAmountDeviation(double userTotalAmounts, double allocatedAmounts){
        return allocatedAmounts-userTotalAmounts;
    }

    private void setDeviationStatus(double deviation){
        AccountStatus deviationStatus=null;
        if(deviationAmount>0){
            deviationStatus= AccountDeviationDes.EXCEEDS_ALLOCATION;
        }else if(deviationAmount<0){
           deviationStatus= AccountStatus.WITHIN_ALLOCATION;
        }else if(deviationAmount==0){
            deviationStatus= AccountStatus.EQUAL_WITH_ALLOCATION;
        }
        return deviationStatus;
    }
}
