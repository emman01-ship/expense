package com.example.restApis.expensetracker.dto;

import com.example.restApis.expensetracker.model.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/*
    Decouple your Domain Layer (Expense.java) with your API/Presentation
    Layer.
    For this reason, we are going to use a Data Transfer Object (DTO) to
    receive the input from the client and then map this object to our
    Domain Model.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDto {

    private String id;
    private String expenseName;
    private ExpenseCategory expenseCategory;
    private BigDecimal expenseAmount;

}
