package com.internship.user_accounts.service;

import com.internship.user_accounts.entity.Accounts;

import java.time.LocalDate;
import java.time.YearMonth;

public interface AccountServices {
    Accounts addAccountsDetails(String date);
}
