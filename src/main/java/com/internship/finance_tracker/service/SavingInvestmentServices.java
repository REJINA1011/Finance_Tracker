package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.SavingAndInvestmentDTO;
import com.internship.finance_tracker.entity.SavingAndInvestment;

public interface SavingInvestmentServices {
    SavingAndInvestment addSavingInvestment(SavingAndInvestmentDTO savingAndInvestmentDTO);
}
