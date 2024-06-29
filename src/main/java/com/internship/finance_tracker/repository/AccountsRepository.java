package com.internship.finance_tracker.repository;

import com.internship.finance_tracker.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
}
