package com.internship.finance_tracker.service;

import com.internship.finance_tracker.dto.IncomeDTO;
import com.internship.finance_tracker.entity.ApiResponse;
import com.internship.finance_tracker.entity.Income;
import com.internship.finance_tracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {


    private final IncomeRepository incomeRepository;

    private Income saveOrUpdateIncomeDetails(Income income, IncomeDTO incomeDTO){
      income.setIncomeId(incomeDTO.getIncomeId());
      income.setCategory(incomeDTO.getCategory());
      income.setAmount(incomeDTO.getAmount());
      income.setDateOfEntry(incomeDTO.getDateOfEntry());
      income.setDescription(incomeDTO.getDescription());

      return incomeRepository.save(income);
    }

    public Income addIncome(IncomeDTO incomeDTO) {
        return saveOrUpdateIncomeDetails(new Income(), incomeDTO);
    }

    public List<Income> getAllAddedIncomes() {
        return incomeRepository.findAll();
    }

    public List<Income> getIncomesByDate(YearMonth dateOfIncomeEntered) {
        return incomeRepository.findByDate(dateOfIncomeEntered);
    }
}
