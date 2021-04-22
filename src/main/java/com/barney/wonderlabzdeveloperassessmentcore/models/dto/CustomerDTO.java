package com.barney.wonderlabzdeveloperassessmentcore.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

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
public class CustomerDTO {
    private String cif;
    private String firstName;
    private String lastName;
    private String nationalID;
    private String mobile;
    private String email;
    private String physicalAddress;
    private Set<InitialDeposit> initialDeposit;
}
