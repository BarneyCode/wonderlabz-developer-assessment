package com.barney.wonderlabzdeveloperassessmentcore.models;

import com.barney.wonderlabzdeveloperassessmentcore.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:21
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends BaseEntity  {
    private String cif;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true)
    private String nationalID;
    private String mobile;
    private String email;
    private String physicalAddress;
}
