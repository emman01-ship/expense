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

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    /*
        map the ExpenseDto object to an Expense object.
     */
    public String addExpense(ExpenseDto expenseDto) {
        Expense expense = mapFromDto(expenseDto);
        return expenseRepository.insert(expense).getId();
    }

    public ExpenseDto getExpense(String name) {
        Expense expense = expenseRepository.findByName(name)
                .orElseThrow(() -> new
                        ExpenseNotFoundException(String
                        .format("Cannot Find Expense by Name - %s", name)));
        return mapToDto(expense);
    }

    public List<ExpenseDto> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()

                .map(this::mapToDto).collect(Collectors.toList());
    }


    /*

     */
    private Expense mapFromDto(ExpenseDto expense) {
        return Expense.builder()
                .expenseName(expense.getExpenseName())
                .expenseCategory(expense.getExpenseCategory())
                .expenseAmount(expense.getExpenseAmount())
                .build();
    }

    private ExpenseDto mapToDto(Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .expenseName(expense.getExpenseName())
                .expenseCategory(expense.getExpenseCategory())
                .expenseAmount(expense.getExpenseAmount())
                .build();
    }

}
