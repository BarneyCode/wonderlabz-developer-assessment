package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.convertors.TransactionDTOConvertor;
import com.barney.wonderlabzdeveloperassessmentcore.dao.TransactionRepository;
import com.barney.wonderlabzdeveloperassessmentcore.exceptions.TransactionException;
import com.barney.wonderlabzdeveloperassessmentcore.models.Account;
import com.barney.wonderlabzdeveloperassessmentcore.models.AccountType;
import com.barney.wonderlabzdeveloperassessmentcore.models.Transaction;
import com.barney.wonderlabzdeveloperassessmentcore.models.TransactionType;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionDTO;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:51
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private static final String CASH_ACCOUNT = "1234567890";
    private final TransactionRepository transactionRepository;
    private final TransactionDTOConvertor transactionDTOConvertor;
    private final AccountService accountService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionDTOConvertor transactionDTOConvertor, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.transactionDTOConvertor = transactionDTOConvertor;
        this.accountService = accountService;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return this.transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    @Override
    public TransactionResponse transact(TransactionDTO transactionDTO) {
        if (transactionDTO.getTransactionType() == null) {
            throw new TransactionException("Please provide the transaction type : " + Arrays.toString(TransactionType.values()));
        } else {
            Transaction transaction = transactionDTOConvertor.convert(transactionDTO);
            Transaction savedTransaction = this.save(transaction);
            switch (savedTransaction.getTransactionType()) {
                case DEPOSIT:
                    return makeDeposit(savedTransaction);
                case WITHDRAWAL:
                    return makeWithdrawal(savedTransaction);
                case TRANSFER_FUNDS:
                    return transferFunds(savedTransaction);
                default:
                    throw new TransactionException("Please provide the transaction type : " + Arrays.toString(TransactionType.values()));
            }
        }
    }

    private TransactionResponse transferFunds(Transaction transaction) {
        if (checkRules(transaction)){
            return moveFunds(transaction);
        }else {
            transaction.setReason("Failed to validate");
            this.save(transaction);
            throw new TransactionException("Validation Failed : " + transaction.getMainAccount());
        }
    }

    private boolean checkRules(Transaction transaction) {
        Optional<Account> optionalSourceAccount = this.accountService.findByAccountNumber(transaction.getMainAccount());
        Optional<Account> optionalDestinationAccount = this.accountService.findByAccountNumber(transaction.getDestinationAccount());
        if (optionalSourceAccount.isEmpty()){
            transaction.setReason("Invalid Source Account");
            this.save(transaction);
            throw new TransactionException("Source account number provided does not exist : " + transaction.getMainAccount());
        }else {
            if (optionalDestinationAccount.isEmpty()){
                transaction.setReason("Invalid Destination Account");
                this.save(transaction);
                throw new TransactionException("Destination account number provided does not exist : " + transaction.getDestinationAccount());
            }else {
                Account sourceAccount = optionalSourceAccount.get();
                if (sourceAccount.getAccountType().equals(AccountType.SAVINGS)){
                    if ((sourceAccount.getBalance().subtract(transaction.getAmount())).compareTo(BigDecimal.valueOf(1000.00)) < 0){
                        transaction.setReason("Low Balance");
                        this.save(transaction);
                        throw new TransactionException("Source Account cannot have balance below 1000.0: " + transaction.getMainAccount());
                    }else {
                        return true;
                    }
                }else if (sourceAccount.getAccountType().equals(AccountType.CURRENT)){
                    if ((sourceAccount.getBalance().subtract(transaction.getAmount())).compareTo(BigDecimal.valueOf(-100000.00)) < 0){
                        transaction.setReason("Low Balance");
                        this.save(transaction);
                        throw new TransactionException("Source Account cannot have balance below -100000.00: " + transaction.getMainAccount());
                    }else {
                        return true;
                    }
                } else {
                    transaction.setReason("Invalid Account Typee");
                    this.save(transaction);
                    throw new TransactionException("Invalid Account Type : " + transaction.getDestinationAccount());
                }
            }
        }
    }

    private TransactionResponse makeWithdrawal(Transaction transaction) {
        //move money from customers account to cash Account
        transaction.setDestinationAccount(CASH_ACCOUNT);
        if (checkRules(transaction)){
            return moveFunds(transaction);
        }else {
            transaction.setReason("Failed to validate");
            this.save(transaction);
            throw new TransactionException("Validation Failed : " + transaction.getMainAccount());
        }
    }

    private TransactionResponse makeDeposit(Transaction transaction) {
        //move money from cash account to Customers Account
        transaction.setDestinationAccount(transaction.getMainAccount());
        transaction.setMainAccount(CASH_ACCOUNT);
        if (checkRules(transaction)){
            return moveFunds(transaction);
        }else {
            transaction.setReason("Failed to validate");
            this.save(transaction);
            throw new TransactionException("Validation Failed : " + transaction.getMainAccount());
        }
    }

    private TransactionResponse moveFunds(Transaction transaction){
        Account sourceAccount = this.accountService.findByAccountNumber(transaction.getMainAccount()).get();
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(transaction.getAmount()));
        this.accountService.save(sourceAccount);

        Account destinationAccount = this.accountService.findByAccountNumber(transaction.getDestinationAccount()).get();
        destinationAccount.setBalance(destinationAccount.getBalance().add(transaction.getAmount()));
        this.accountService.save(destinationAccount);

        this.save(transaction);
        return new TransactionResponse(transaction.getId().toString(),transaction.getMainAccount(),transaction.getDestinationAccount(),transaction.getAmount());
    }
}
