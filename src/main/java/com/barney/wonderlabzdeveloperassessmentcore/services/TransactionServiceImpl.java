package com.barney.wonderlabzdeveloperassessmentcore.services;

import com.barney.wonderlabzdeveloperassessmentcore.dao.TransactionRepository;
import com.barney.wonderlabzdeveloperassessmentcore.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
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
}
