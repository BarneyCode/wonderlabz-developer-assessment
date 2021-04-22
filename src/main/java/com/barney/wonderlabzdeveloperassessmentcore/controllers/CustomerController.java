package com.barney.wonderlabzdeveloperassessmentcore.controllers;

import com.barney.wonderlabzdeveloperassessmentcore.common.ApiMessage;
import com.barney.wonderlabzdeveloperassessmentcore.common.ApiResponse;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerResponse;
import com.barney.wonderlabzdeveloperassessmentcore.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:52
 */
@RequestMapping(value = "/api/v1/customer")
@RestController
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ApiResponse<CustomerResponse> openCustomerAccount(@RequestBody CustomerDTO customerDTO){
        log.info("Creating a new customer " + customerDTO);
        CustomerResponse customerResponse = this.customerService.createCustomer(customerDTO);
        return new ApiResponse<>(200, ApiMessage.SUCCESS,customerResponse);
    }

}
