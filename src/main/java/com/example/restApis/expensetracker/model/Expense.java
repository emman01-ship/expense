package com.example.restApis.expensetracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tab")
public class Expense {
    @Id
    private String id;
    @Indexed(unique = true)
    private String expenseName;
    private ExpenseCategory expenseCategory;
    private BigDecimal expenseAmount;
    public String getId() {
        return id;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

}
