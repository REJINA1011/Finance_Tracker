package com.internship.user_expense.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.user_expense.dto.ExpenseDTO;
import com.internship.user_expense.dto.UserDto;
import com.internship.user_expense.entity.ApiResponse;
import com.internship.user_expense.entity.ExpenseCategory;
import com.internship.user_expense.entity.Expenses;
import com.internship.user_expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    private RestTemplate template;
    private String Url = "http://localhost:8086/api/users/getUserData/";
    private ObjectMapper objectMapper = new ObjectMapper();

    private Expenses saveOrUpdateExpenseDetails(Expenses expenses, ExpenseDTO expenseDTO,String email){

        expenses.setAmount(expenseDTO.getAmount());
        expenses.setExpenseId(expenseDTO.getExpenseId());
        expenses.setDateOfExpense(expenseDTO.getDateOfExpense());
        expenses.setDescription(expenseDTO.getDescription());
        ApiResponse response= this.template.getForObject(Url+email,ApiResponse.class);
        UserDto userDto = this.objectMapper.convertValue(response.getData(), UserDto.class);
        expenses.setUserId(userDto.getId());


        ExpenseCategory categoryCheck=expenseDTO.getCategory();
        if (categoryCheck == ExpenseCategory.NEEDS || categoryCheck== ExpenseCategory.WANTS) {
            expenses.setCategory(categoryCheck);
        }

        return expenseRepository.save(expenses);
    }

    public Expenses addExpenses(ExpenseDTO expenseDTO,String email) {
        return saveOrUpdateExpenseDetails(new Expenses(), expenseDTO,email);
    }

    public List<Expenses> getAllAddedExpense() {
        return expenseRepository.findAll();
    }

    public List<Expenses> getAllExpensesByUserId(Long id){
        return this.expenseRepository.getExpenseByUserId(id);
    }
    public List<Expenses> getExpenseByDate(String monthOfExpenseEntered,Long userId) {
        return expenseRepository.findAllByMonth(monthOfExpenseEntered,userId);
    }

    public List<Expenses> getExpenseByDay(String monthOfExpenseEntered, int dayOfExpenseEntered) {
        return expenseRepository.findByDay(monthOfExpenseEntered,dayOfExpenseEntered);

    }

    public double getAllExpensesByCategory(String yearMonth, ExpenseCategory category,Long userId) {
        double totalAmount=0;
        List<Double> amountsList=expenseRepository.getAmountsAsPerCategory(yearMonth,category,userId);
        for(double amount:amountsList) {
            totalAmount += amount;
        }
        return totalAmount;
    }

    public List<Expenses> getAllExpensesEachDayByCategory(String yearMonth, int dayOfEntry, ExpenseCategory category,Long userId) {
        return expenseRepository.getExpensesEachDayAsPerCategory(yearMonth,dayOfEntry,category,userId);
    }

    public double getAllExpensesPerDayByCategory(String yearMonth, int dayOfEntry, ExpenseCategory category,Long userId) {
        double totalAmount=0;
        List<Double> amounts=expenseRepository.getAmountsAsPerDayAndCategory(yearMonth,dayOfEntry,category,userId);
        if (!amounts.isEmpty()) {
            for (double amount : amounts) {
                totalAmount += amount;
            }
        }
        return totalAmount;
    }

    public List<Expenses> getReports(int days,Long userId){
        String startDate =LocalDate.now().minusDays(days).toString();
        String endDayOfMonth=LocalDate.now().toString();

        return expenseRepository.findReportsAfterDate(startDate,userId,endDayOfMonth);

    }
}
