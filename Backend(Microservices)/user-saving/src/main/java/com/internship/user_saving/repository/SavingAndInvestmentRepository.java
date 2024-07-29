package com.internship.user_saving.repository;
import com.internship.user_saving.entity.SavingAndInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface SavingAndInvestmentRepository extends JpaRepository<SavingAndInvestment,Long> {
    @Query("SELECT saving.amount FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:date")
    List<Double> getSavingAmounts(String date);

    @Query("SELECT saving FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:monthOfSavingsEntered")
    List<SavingAndInvestment> findAllByDate(String monthOfSavingsEntered);

    @Query("SELECT saving FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:monthOfSavingsEntered AND saving.dayOfTheMonth=:dayOfSavingsEntered")
    List<SavingAndInvestment> findAllByDay(String monthOfSavingsEntered, int dayOfSavingsEntered);

    @Query("SELECT saving.amount FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:dateOfEntry AND saving.dayOfTheMonth=:dayOfMonth")
    List<Double> getSavingAmountGivenDate(String dateOfEntry, String dayOfMonth);
}
