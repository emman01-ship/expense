package com.example.restApis.expensetracker.web;

import com.example.restApis.expensetracker.dto.ExpenseDto;
import com.example.restApis.expensetracker.model.Expense;
import com.example.restApis.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/*
    Accept the incoming request
 */

@RequestMapping("/expense")
@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    /*
        We are receiving the ExpenseDto as a @RequestBody and we are passing on
        this object to ExpenseService which returns the expenseId of the created
        Expense.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @PutMapping
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
    }

}
