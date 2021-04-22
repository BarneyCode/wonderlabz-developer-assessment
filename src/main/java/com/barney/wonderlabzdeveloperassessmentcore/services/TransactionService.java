package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.common.AppService;
import com.barney.wonderlabzdeveloperassessmentcore.models.Transaction;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionResponse;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:39
 */
public interface TransactionService extends AppService<Transaction> {
    TransactionResponse transact(TransactionDTO transactionDTO);
}
