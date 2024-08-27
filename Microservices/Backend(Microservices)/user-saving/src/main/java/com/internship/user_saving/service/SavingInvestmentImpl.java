package com.internship.user_saving.service;

import com.internship.user_saving.dto.SavingAndInvestmentDTO;
import com.internship.user_saving.entity.SavingAndInvestment;
import com.internship.user_saving.entity.SavingAndInvestmentCategory;
import com.internship.user_saving.repository.SavingAndInvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingInvestmentImpl implements SavingInvestmentServices {

    private final SavingAndInvestmentRepository savingAndInvestmentRepository;

    private SavingAndInvestment saveOrUpdateSavingInvestmentDetails(SavingAndInvestment savingAndInvestment, SavingAndInvestmentDTO savingAndInvestmentDTO,Long userId){

        savingAndInvestment.setAmount(savingAndInvestmentDTO.getAmount());
        savingAndInvestment.setSavingId(savingAndInvestmentDTO.getSavingInvestmentId());
        savingAndInvestment.setDateOfEntry(savingAndInvestmentDTO.getDateOfEntry());
        savingAndInvestment.setDayOfTheMonth(savingAndInvestmentDTO.getDayOfTheMonth());
        savingAndInvestment.setCategory(savingAndInvestmentDTO.getCategory());
        savingAndInvestment.setDescription(savingAndInvestmentDTO.getDescription());
        savingAndInvestment.setUserId(userId);

        SavingAndInvestmentCategory categoryCheck=savingAndInvestmentDTO.getCategory();
        if (categoryCheck==SavingAndInvestmentCategory.FIXED_DEPOSIT||
                categoryCheck== SavingAndInvestmentCategory.CURRENT_DEPOSIT||
                categoryCheck== SavingAndInvestmentCategory.BOND ||
                categoryCheck== SavingAndInvestmentCategory.SHARE) {

            savingAndInvestment.setCategory(categoryCheck);
        }
        return savingAndInvestmentRepository.save(savingAndInvestment);
    }

    public SavingAndInvestment addSavingInvestment(SavingAndInvestmentDTO savingAndInvestmentDTO,Long userId) {
        return saveOrUpdateSavingInvestmentDetails(new SavingAndInvestment(), savingAndInvestmentDTO,userId);
    }

    public List<SavingAndInvestment> getAllAddedSavings() {
        return savingAndInvestmentRepository.findAll();
    }

    public List<SavingAndInvestment> getSavingsByDate(String monthOfSavingsEntered,Long userId) {
        return savingAndInvestmentRepository.findAllByDate(monthOfSavingsEntered,userId);
    }

    public List<SavingAndInvestment> getSavingsByDay(String monthOfSavingsEntered, int dayOfSavingsEntered) {
        return savingAndInvestmentRepository.findAllByDay(monthOfSavingsEntered, dayOfSavingsEntered);
    }

    public double getSavingsAmount(String date,Long userId) {

        double totalAmount=0;
        List<Double> amounts=savingAndInvestmentRepository.getSavingAmounts(date,userId);
        for(double amount:amounts) {
            totalAmount += amount;
        }
        return totalAmount;
    }

    public double getSavingsAmountCurrentDay(String dateOfEntry, String dayOfMonth,Long userId) {
        double totalAmount=0;
        List<Double> amounts=savingAndInvestmentRepository.getSavingAmountGivenDate(dateOfEntry,dayOfMonth,userId);
        if (!amounts.isEmpty()) {
            for(double amount:amounts){
                totalAmount+=amount;
            }
        }
        return totalAmount;
    }

    public List<SavingAndInvestment> getReports(int days, Long userId) {
        String startDate = LocalDate.now().minusDays(days).toString();
        String endDayOfMonth=LocalDate.now().toString();

        return savingAndInvestmentRepository.findReportsAfterDate(startDate,userId,endDayOfMonth);
    }
}
