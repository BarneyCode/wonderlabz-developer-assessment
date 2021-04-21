package com.barney.wonderlabzdeveloperassessmentcore.controllers;

import com.barney.wonderlabzdeveloperassessmentcore.common.ApiMessage;
import com.barney.wonderlabzdeveloperassessmentcore.common.ApiResponse;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionResponse;
import com.barney.wonderlabzdeveloperassessmentcore.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 00:29
 */
@RequestMapping(value = "/api/v1/transact")
@RestController
@Slf4j
public class TransactionController {

    public final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public ApiResponse<TransactionResponse> makeTransaction(@RequestBody TransactionDTO transactionDTO) {

        log.info("new transaction " + transactionDTO + " of type " + transactionDTO.getTransactionType());
        TransactionResponse transact = this.transactionService.transact(transactionDTO);
        return new ApiResponse<>(200, ApiMessage.SUCCESS, transact);


    }
}
