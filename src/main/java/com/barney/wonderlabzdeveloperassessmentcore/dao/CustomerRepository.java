package com.barney.wonderlabzdeveloperassessmentcore.dao;

import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:40
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
