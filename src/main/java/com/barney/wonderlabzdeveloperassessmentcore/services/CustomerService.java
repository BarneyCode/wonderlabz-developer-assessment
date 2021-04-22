package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.common.AppService;
import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerResponse;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:38
 */
public interface CustomerService extends AppService<Customer> {
    CustomerResponse createCustomer(CustomerDTO customerDTO);
}
