package com.example.restApis.expensetracker.web;

import com.example.restApis.expensetracker.dto.ExpenseDto;
import com.example.restApis.expensetracker.model.Expense;
import com.example.restApis.expensetracker.repository.ExpenseRepository;
import com.example.restApis.expensetracker.service.ExpenseService;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

/*
    Accept the incoming request
 */

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;
    /*
        We are receiving the ExpenseDto as a @RequestBody and we are passing on
        this object to ExpenseService which returns the expenseId of the created
        Expense.
     */
    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addExpense(@RequestBody ExpenseDto
                                                   expenseDto) {
        String expenseId = expenseService.addExpense(expenseDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(expenseId)
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateExpense(@RequestBody ExpenseDto expense) {
        expenseService.updateExpense(expense);
    }

    /*
        We are receiving the expenseName as a URL PathVariable, and we are
        returning the ExpenseDto back to the client.
     */
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ExpenseDto getExpenseByName(@PathVariable String name) {
        return expenseService.getExpense(name);
    }

    @GetMapping("/expense")
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @DeleteMapping("/deleteAllNull")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNullExpenses(){

        expenseService.getAllExpenses().stream().filter(
            expense -> Objects.isNull(expense.getExpenseName())
        ).forEach(noValue ->expenseService.deleteExpense(noValue.getId()));

    }

    @DeleteMapping("/deleteByName")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpensesByName(@Param("expenseName") @Nullable String expenseName){

        expenseService.getAllExpenses().stream().filter(
                expense -> expense.getExpenseName().equals(expenseName)
        ).forEach(value -> expenseService.deleteExpense(value.getId()));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
    }


    @GetMapping("/error")
    @ResponseStatus(HttpStatus.OK)
    String error(HttpServletRequest request) {
        return "<h1>Error occurred</h1>";
    }



}
