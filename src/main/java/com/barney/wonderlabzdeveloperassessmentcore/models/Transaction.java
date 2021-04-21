package com.barney.wonderlabzdeveloperassessmentcore.models;

import com.barney.wonderlabzdeveloperassessmentcore.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:28
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction extends BaseEntity {

    private TransactionType transactionType;
}
