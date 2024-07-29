package com.internship.user_income.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;

    @Column(nullable = false, updatable = false)
    private String dateOfEntry;

    @Column(nullable = false, updatable = false)
    private int dayOfTheMonth;

    private double amount;

    private String category;

    private String description;


    @PrePersist
    protected void onCreate() {

        dateOfEntry = YearMonth.now().toString();
        dayOfTheMonth=LocalDate.now().getDayOfMonth();
    }

}
