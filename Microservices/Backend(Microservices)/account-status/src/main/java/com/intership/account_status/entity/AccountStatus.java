package com.intership.account_status.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.YearMonth;
import java.util.List;

@Entity
@Data
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountStatusId;

    private YearMonth dateOfEntry;

    private Long accountId;

    @Transient
    private List<DeviationDes> deviationAmount;

}
