package com.barney.wonderlabzdeveloperassessmentcore.models.dto;

import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

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
public class TransactionResponse {
    private String referenceNumber;
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;
}
