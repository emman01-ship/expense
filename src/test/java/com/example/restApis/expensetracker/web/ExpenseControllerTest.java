package com.example.restApis.expensetracker.web;

import com.example.restApis.expensetracker.dto.ExpenseDto;
import com.example.restApis.expensetracker.dto.ExpenseDtoBuilder;
import com.example.restApis.expensetracker.model.ExpenseCategory;
import com.example.restApis.expensetracker.service.ExpenseService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = ExpenseController.class)
public class ExpenseControllerTest {
    @Mock
    private ExpenseService expenseService;

    @Mock
    private ExpenseDtoBuilder expenseDtoBuilder;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    @Test
    @DisplayName("Should Create Expense")
    public void shouldCreateExpense() throws Exception {

        ExpenseDto expenseDto = ExpenseDto.builder()
                .expenseCategory(ExpenseCategory.ENTERTAINMENT)
                .expenseName("Movies")
                .expenseAmount(BigDecimal.TEN)
                .build();



        Mockito.when(expenseService.addExpense(expenseDto)).thenReturn("123");

                MvcResult mvcResult = mockMvc.perform(post("/api/expense"))

                        .andExpect(MockMvcResultMatchers.status().isCreated())

                        .andExpect(MockMvcResultMatchers.header()
                                .exists(HttpHeaders.LOCATION))
                        .andReturn();


        assertTrue(mvcResult.getResponse().getHeaderValue(HttpHeaders.LOCATION)
                .toString().contains("123"));

    }
}
