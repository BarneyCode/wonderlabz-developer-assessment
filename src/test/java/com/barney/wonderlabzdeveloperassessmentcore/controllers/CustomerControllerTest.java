package com.barney.wonderlabzdeveloperassessmentcore.controllers;

import com.barney.wonderlabzdeveloperassessmentcore.common.ApiMessage;
import com.barney.wonderlabzdeveloperassessmentcore.common.ApiResponse;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerResponse;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.InitialDeposit;
import com.barney.wonderlabzdeveloperassessmentcore.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 22:06
 */
@WebMvcTest(controllers = {CustomerController.class})
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private CustomerService customerService;
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void openCustomerAccount_Test() throws Exception {
        final var url = "/api/v1/customer/createCustomer";
        final var apiResponse = new ApiResponse<CustomerResponse>(200, ApiMessage.SUCCESS);
        given(customerService.createCustomer(any(CustomerDTO.class))).willReturn(apiResponse.getBody());
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CustomerDTO("","Barnabas","Katakwa","752035136V71","0772447112","barneykatakwa@gmail.com","5 Hockham",
                        new HashSet<>(Set.of(new InitialDeposit(AccountType.SAVINGS, BigDecimal.valueOf(60000)),new InitialDeposit(AccountType.CURRENT, BigDecimal.valueOf(10000))))))).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value(200))
                .andExpect(jsonPath("message").value(ApiMessage.SUCCESS.name()))
                .andExpect(jsonPath("body").value(IsNull.nullValue()));
        verify(customerService,times(1)).createCustomer(any(CustomerDTO.class));
    }
}