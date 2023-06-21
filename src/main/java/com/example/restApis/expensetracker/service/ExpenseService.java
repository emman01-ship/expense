package com.example.restApis.expensetracker.service;

import com.example.restApis.expensetracker.dto.ExpenseDto;
import com.example.restApis.expensetracker.exception.ExpenseNotFoundException;
import com.example.restApis.expensetracker.model.Expense;
import com.example.restApis.expensetracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



public interface ExpenseService {

    /*
        map the ExpenseDto object to an Expense object.
     */
    public String addExpense(ExpenseDto expenseDto);

    public void updateExpense(ExpenseDto expenseDto);

    public ExpenseDto getExpense(String name);

    public List<ExpenseDto> getAllExpenses();

    public void deleteExpense(String id);

    /*

     */

}
