package com.barney.wonderlabzdeveloperassessmentcore.models;

import com.barney.wonderlabzdeveloperassessmentcore.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:24
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account extends BaseEntity {
    private String accountNumber;
    private String balance;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
