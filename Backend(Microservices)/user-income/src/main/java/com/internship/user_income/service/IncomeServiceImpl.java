package com.internship.user_income.service;

import com.internship.user_income.dto.IncomeDTO;
import com.internship.user_income.entity.ApiResponse;
import com.internship.user_income.entity.Income;
import com.internship.user_income.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public List<Double> getAllIncomeAmount(YearMonth dateOfIncomeEntered) {
        return incomeRepository.getAllIncomeAmount(dateOfIncomeEntered);
    }
}
