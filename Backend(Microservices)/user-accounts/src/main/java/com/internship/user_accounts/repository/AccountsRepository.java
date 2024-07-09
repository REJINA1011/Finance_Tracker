package com.internship.user_accounts.repository;

import com.internship.user_accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.YearMonth;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    @Query("SELECT accounts FROM Accounts accounts where accounts.date=:date")
    Accounts getAllAccounts(YearMonth date);

}
