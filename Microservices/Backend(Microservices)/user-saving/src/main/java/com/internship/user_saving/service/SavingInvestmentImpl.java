package com.internship.user_saving.service;

import com.internship.user_saving.dto.SavingAndInvestmentDTO;
import com.internship.user_saving.entity.SavingAndInvestment;
import com.internship.user_saving.entity.SavingAndInvestmentCategory;
import com.internship.user_saving.repository.SavingAndInvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingInvestmentImpl implements SavingInvestmentServices {

    private final SavingAndInvestmentRepository savingAndInvestmentRepository;

    private SavingAndInvestment saveOrUpdateSavingInvestmentDetails(SavingAndInvestment savingAndInvestment, SavingAndInvestmentDTO savingAndInvestmentDTO){

        savingAndInvestment.setAmount(savingAndInvestmentDTO.getAmount());
        savingAndInvestment.setSavingId(savingAndInvestmentDTO.getSavingInvestmentId());
        savingAndInvestment.setDateOfEntry(savingAndInvestmentDTO.getDateOfEntry());
        savingAndInvestment.setDayOfTheMonth(savingAndInvestmentDTO.getDayOfTheMonth());
        savingAndInvestment.setCategory(savingAndInvestmentDTO.getCategory());
        savingAndInvestment.setDescription(savingAndInvestmentDTO.getDescription());

        SavingAndInvestmentCategory categoryCheck=savingAndInvestmentDTO.getCategory();
        if (categoryCheck==SavingAndInvestmentCategory.FIXED_DEPOSIT||
                categoryCheck== SavingAndInvestmentCategory.CURRENT_DEPOSIT||
                categoryCheck== SavingAndInvestmentCategory.BOND ||
                categoryCheck== SavingAndInvestmentCategory.SHARE) {

            savingAndInvestment.setCategory(categoryCheck);
        }
        return savingAndInvestmentRepository.save(savingAndInvestment);
    }

    public SavingAndInvestment addSavingInvestment(SavingAndInvestmentDTO savingAndInvestmentDTO) {
        return saveOrUpdateSavingInvestmentDetails(new SavingAndInvestment(), savingAndInvestmentDTO);
    }

    public List<SavingAndInvestment> getAllAddedSavings() {
        return savingAndInvestmentRepository.findAll();
    }

    public List<SavingAndInvestment> getSavingsByDate(String monthOfSavingsEntered) {
        return savingAndInvestmentRepository.findAllByDate(monthOfSavingsEntered);
    }

    public List<SavingAndInvestment> getSavingsByDay(String monthOfSavingsEntered, int dayOfSavingsEntered) {
        return savingAndInvestmentRepository.findAllByDay(monthOfSavingsEntered, dayOfSavingsEntered);
    }

    public double getSavingsAmount(String date) {

        double totalAmount=0;
        List<Double> amounts=savingAndInvestmentRepository.getSavingAmounts(date);
        for(double amount:amounts) {
            totalAmount += amount;
        }
        return totalAmount;
    }

    public double getSavingsAmountCurrentDay(String dateOfEntry, String dayOfMonth) {
        double totalAmount=0;
        List<Double> amounts=savingAndInvestmentRepository.getSavingAmountGivenDate(dateOfEntry,dayOfMonth);
        if (!amounts.isEmpty()) {
            for(double amount:amounts){
                totalAmount+=amount;
            }
        }
        return totalAmount;
    }
}
