package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.dao.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 23:32
 */
class AccountServiceTest {


    private AccountService accountService;
    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountService = new AccountServiceImpl();
    }

    @Test
    @DisplayName("creating customer account")
    void createAccounts() {
    }

    @Test
    @DisplayName("find list of customers")
    void findByAccountNumber() {
    }
}