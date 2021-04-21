package com.barney.wonderlabzdeveloperassessmentcore.models;

import com.barney.wonderlabzdeveloperassessmentcore.common.BaseEntity;
import lombok.*;

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
    private String CIF;
    private String firstName;
    private String lastName;
}
