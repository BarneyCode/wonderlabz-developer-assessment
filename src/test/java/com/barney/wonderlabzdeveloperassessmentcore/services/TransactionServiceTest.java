package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.dao.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 23/4/2021
 * Time        : 09:57
 */
class TransactionServiceTest {

    private TransactionService transactionService;
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        transactionService = new TransactionServiceImpl();
    }
    @Test
    @DisplayName("transaction test")
    void transact() {
    }
}