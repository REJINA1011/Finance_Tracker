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

    public List<SavingAndInvestment> getSavingsByDate(YearMonth monthOfSavingsEntered) {
        return savingAndInvestmentRepository.findAllByDate(monthOfSavingsEntered);
    }

    public List<SavingAndInvestment> getSavingsByDay(YearMonth monthOfSavingsEntered, int dayOfSavingsEntered) {
        return savingAndInvestmentRepository.findAllByDay(monthOfSavingsEntered, dayOfSavingsEntered);
    }

    public List<Double> getSavingsAmount(YearMonth date) {
        return savingAndInvestmentRepository.getSavingAmounts(date);
    }
}
