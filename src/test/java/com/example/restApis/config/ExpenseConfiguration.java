package com.example.restApis.config;

import com.example.restApis.expensetracker.dto.ExpenseDto;
import com.example.restApis.expensetracker.repository.ExpenseRepository;
import com.example.restApis.expensetracker.service.ExpenseService;
import com.example.restApis.expensetracker.service.ExpenseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("tests")
@Configuration
public class ExpenseConfiguration {

    @Bean(name = "expenseService")
    @Primary
    public ExpenseService expenseService(ExpenseRepository expenseRepository){
        return new ExpenseServiceImpl(expenseRepository);
    }
}
