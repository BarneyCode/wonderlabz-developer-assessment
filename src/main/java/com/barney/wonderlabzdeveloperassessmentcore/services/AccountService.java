package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.common.AppService;
import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;

import java.util.Map;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:38
 */
public interface AccountService extends AppService<Account> {
    Map<AccountType, Account> createAccounts(CustomerDTO customerDTO);
}
