package org.financecontrol401.service;

import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

public class FindService {
    private final TransactionRepository transactionRepository;

    public FindService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findByDate(LocalDate date) {
        return transactionRepository.findByDate(date);
    }

    public List<Transaction> findByPeriod(LocalDate startDate, LocalDate endDate) {
        return transactionRepository.findByPeriod(startDate, endDate);
    }

    public List<Transaction> findByCategory(String categoryName) {
        return transactionRepository.findByCategory(categoryName);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findByPeriodAndCategory(LocalDate startDate, LocalDate endDate, String categoryName) {
        return transactionRepository.findByPeriodAndCategory(startDate, endDate, categoryName);
    }

    public List<Transaction> findByTypeAndPeriod(LocalDate startDate, LocalDate endDate, TransactionType type) {
        return transactionRepository.findByTypeAndPeriod(startDate, endDate, type);
    }


}
