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
    @Query("SELECT saving.amount FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:date AND saving.userId=:userId")
    List<Double> getSavingAmounts(String date,Long userId);

    @Query("SELECT saving FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:monthOfSavingsEntered AND saving.userId=:userId")
    List<SavingAndInvestment> findAllByDate(String monthOfSavingsEntered,Long userId);

    @Query("SELECT saving FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:monthOfSavingsEntered AND saving.dayOfTheMonth=:dayOfSavingsEntered")
    List<SavingAndInvestment> findAllByDay(String monthOfSavingsEntered, int dayOfSavingsEntered);

    @Query("SELECT saving.amount FROM SavingAndInvestment saving WHERE saving.dateOfEntry=:dateOfEntry AND saving.dayOfTheMonth=:dayOfMonth AND saving.userId=:userId")
    List<Double> getSavingAmountGivenDate(String dateOfEntry, String dayOfMonth,Long userId);

    @Query("SELECT e FROM SavingAndInvestment e WHERE e.userId=:userId AND e.date BETWEEN:startDate AND :endDayOfMonth" )
    List<SavingAndInvestment> findReportsAfterDate(String startDate, Long userId, String endDayOfMonth);
}
