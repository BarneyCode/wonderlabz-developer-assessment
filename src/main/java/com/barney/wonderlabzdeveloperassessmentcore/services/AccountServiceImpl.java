package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.dao.AccountRepository;
import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.TransactionType;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.InitialDeposit;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:41
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionService transactionService;

/*    public AccountServiceImpl(AccountRepository accountRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }*/

    @Override
    public Optional<Account> findById(Long id) {
        return this.accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public Map<AccountType, Account> createAccounts(CustomerDTO customerDTO) {
        Map<AccountType, Account> accountMap = new HashMap<>();
        Set<InitialDeposit> initialDeposit = customerDTO.getInitialDeposit();
        InitialDeposit savingsInitialDeposit = initialDeposit.stream().filter(e -> e.getAccountType().equals(AccountType.SAVINGS)).findFirst().get();
        String savingsAccountNumber = customerDTO.getCif() + "000000";
        Account savingsAccount = new Account(savingsAccountNumber,savingsInitialDeposit.getAmount(),AccountType.SAVINGS);
        savingsAccount.setBalance(BigDecimal.ZERO);
        accountMap.put(AccountType.SAVINGS,savingsAccount);
        this.save(savingsAccount);
        this.transactionService.transact(new TransactionDTO(savingsInitialDeposit.getAmount(),savingsAccountNumber,"","initial deposit", TransactionType.DEPOSIT));//save initial deposit to transaction history
        //save savings account here

        String currentAccountNumber = customerDTO.getCif() + "111111";
        InitialDeposit currentInitialDeposit = initialDeposit.stream().filter(e -> e.getAccountType().equals(AccountType.CURRENT)).findFirst().get();
        Account currentAccount = new Account(currentAccountNumber,currentInitialDeposit.getAmount(),AccountType.CURRENT);
        accountMap.put(AccountType.CURRENT,currentAccount);
        currentAccount.setBalance(BigDecimal.ZERO);
        this.save(currentAccount);
        this.transactionService.transact(new TransactionDTO(currentInitialDeposit.getAmount(),currentAccountNumber,"","initial deposit", TransactionType.DEPOSIT));//save initial deposit to transaction history

        return accountMap;
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return this.accountRepository.findByAccountNumber(accountNumber);
    }
}
