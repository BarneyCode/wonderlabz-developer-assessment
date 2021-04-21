package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.convertors.CustomerDTOConvertor;
import com.barney.wonderlabzdeveloperassessmentcore.dao.CustomerRepository;
import com.barney.wonderlabzdeveloperassessmentcore.exceptions.AccountCreationException;
import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerResponse;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.InitialDeposit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:50
 */
@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDTOConvertor customerDTOConvertor;
    private final CustomerRepository customerRepository;
    private final AccountService accountService;

    public CustomerServiceImpl(CustomerDTOConvertor customerDTOConvertor, CustomerRepository customerRepository, AccountService accountService) {
        this.customerDTOConvertor = customerDTOConvertor;
        this.customerRepository = customerRepository;
        this.accountService = accountService;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public CustomerResponse createCustomer(CustomerDTO customerDTO) {
        Set<InitialDeposit> initialDeposit = customerDTO.getInitialDeposit();
        Optional<InitialDeposit> optionalInitialDeposit = initialDeposit.stream().filter(e -> e.getAccountType().equals(AccountType.SAVINGS)).findFirst();
        if (optionalInitialDeposit.isEmpty()){
            throw new AccountCreationException("Please provide an initial deposit for the customer " + customerDTO.getFirstName());
        } else {
            InitialDeposit initialDepositCustomer = optionalInitialDeposit.get();
            if (initialDepositCustomer.getAmount().compareTo(BigDecimal.valueOf(1000.00))<0){
                throw new AccountCreationException("Please ensure the initial deposit is greater than 1000.00 for " + customerDTO.getFirstName());
            }else {
                Customer customer = this.customerDTOConvertor.convert(customerDTO);
                //set customer CIF it should be auto generated
                //add logic to get unique CustomerID
                Customer savedCustomer = this.save(customer);
                customerDTO.setCif(savedCustomer.getCif());
                //create customer accounts
                Map<AccountType, Account> accounts = this.accountService.createAccounts(customerDTO);
                return new CustomerResponse(savedCustomer,accounts);
            }
        }
    }
}
