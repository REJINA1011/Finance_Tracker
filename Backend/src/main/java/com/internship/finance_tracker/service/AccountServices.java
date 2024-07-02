package com.internship.finance_tracker.service;

import com.internship.finance_tracker.entity.Accounts;

import java.time.LocalDate;
import java.time.YearMonth;

public interface AccountServices {
    Accounts addAccountsDetails(YearMonth date);
}
