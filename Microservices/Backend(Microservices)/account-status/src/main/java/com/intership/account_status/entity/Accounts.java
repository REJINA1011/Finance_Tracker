package com.intership.account_status.entity;

import lombok.Data;

import java.time.YearMonth;

@Data
public class Accounts {

    private Long accountId;

    private YearMonth date;

    private double income;

    private double spentOnNeeds;
    private double allocatedNeeds;
    private double spentOnWants;
    private double allocatedWants;
    private double spendOnSavings;
    private double allocatedSavings;
}
