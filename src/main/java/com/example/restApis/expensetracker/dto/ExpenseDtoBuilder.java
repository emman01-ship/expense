package com.example.restApis.expensetracker.dto;

import com.example.restApis.expensetracker.model.ExpenseCategory;

import java.math.BigDecimal;

public class ExpenseDtoBuilder {
    private String id;
    private String expenseName;
    private ExpenseCategory expenseCategory;
    private BigDecimal expenseAmount;

    public ExpenseDtoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ExpenseDtoBuilder setExpenseName(String expenseName) {
        this.expenseName = expenseName;
        return this;
    }

    public ExpenseDtoBuilder setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
        return this;
    }

    public ExpenseDtoBuilder setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
        return this;
    }

    public ExpenseDto createExpenseDto() {
        return new ExpenseDto(id, expenseName, expenseCategory, expenseAmount);
    }
}