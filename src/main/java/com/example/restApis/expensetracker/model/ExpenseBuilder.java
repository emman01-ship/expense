package com.example.restApis.expensetracker.model;

import java.math.BigDecimal;

public class ExpenseBuilder {
    private String id;
    private String expenseName;
    private ExpenseCategory expenseCategory;
    private BigDecimal expenseAmount;

    public ExpenseBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ExpenseBuilder setExpenseName(String expenseName) {
        this.expenseName = expenseName;
        return this;
    }

    public ExpenseBuilder setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
        return this;
    }

    public ExpenseBuilder setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
        return this;
    }

    public Expense createExpense() {
        return new Expense(id, expenseName, expenseCategory, expenseAmount);
    }
}