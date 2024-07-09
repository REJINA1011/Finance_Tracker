package com.intership.account_status.entity;

import lombok.Data;

@Data
public class DeviationDes {

    private double deviationAmount;
    private AccountStatus status;
    private AccountCategory category;
}
