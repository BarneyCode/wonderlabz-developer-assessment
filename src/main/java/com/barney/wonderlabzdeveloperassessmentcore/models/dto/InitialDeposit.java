package com.barney.wonderlabzdeveloperassessmentcore.models.dto;

import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 23:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InitialDeposit {
    private AccountType accountType;
    private BigDecimal amount;
}
