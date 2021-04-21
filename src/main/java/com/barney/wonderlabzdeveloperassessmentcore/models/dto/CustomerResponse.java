package com.barney.wonderlabzdeveloperassessmentcore.models.dto;

import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;
import java.util.Set;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerResponse {
    private Customer customer;
    private Map<AccountType, Account> accounts;
}
