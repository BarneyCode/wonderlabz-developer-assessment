package com.barney.wonderlabzdeveloperassessmentcore.models.dto;

import com.barney.wonderlabzdeveloperassessmentcore.models.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 00:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {

    private BigDecimal amount;
    private String mainAccount;
    private String destinationAccount;
    private String narration;
    private TransactionType transactionType;
}
