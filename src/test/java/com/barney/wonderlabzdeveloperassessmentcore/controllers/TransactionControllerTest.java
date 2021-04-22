package com.barney.wonderlabzdeveloperassessmentcore.controllers;

import com.barney.wonderlabzdeveloperassessmentcore.common.ApiMessage;
import com.barney.wonderlabzdeveloperassessmentcore.common.ApiResponse;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.Transaction;
import com.barney.wonderlabzdeveloperassessmentcore.models.TransactionType;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.*;
import com.barney.wonderlabzdeveloperassessmentcore.services.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 22:06
 */
@WebMvcTest(controllers = {TransactionController.class})
class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private TransactionService transactionService;
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("transaction test")
    void makeTransaction() throws Exception {
        final var url = "/api/v1/transact";
        final var apiResponse = new ApiResponse<TransactionResponse>(200, ApiMessage.SUCCESS);
        given(transactionService.transact(any(TransactionDTO.class))).willReturn(apiResponse.getBody());
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new TransactionDTO(BigDecimal.valueOf(1000.00),"10001111","","deposit", TransactionType.DEPOSIT))).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value(200))
                .andExpect(jsonPath("message").value(ApiMessage.SUCCESS.name()))
                .andExpect(jsonPath("body").value(IsNull.nullValue()));
        verify(transactionService,times(1)).transact(any(TransactionDTO.class));
    }

    @Test
    void transactionsHistory() throws Exception {
        final var url = "/api/v1/transact/history";
        final var apiResponse = new ApiResponse<List<Transaction>>(200, ApiMessage.SUCCESS);
        given(transactionService.findAll()).willReturn(apiResponse.getBody());
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value(200))
                .andExpect(jsonPath("message").value(ApiMessage.SUCCESS.name()))
                .andExpect(jsonPath("body").value(IsNull.nullValue()));
        verify(transactionService,times(1)).findAll();
    }
}