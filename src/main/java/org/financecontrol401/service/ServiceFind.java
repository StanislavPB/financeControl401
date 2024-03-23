package org.financecontrol401.service;

import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

// Сервис для поиска транзакций
public class ServiceFind {
    private final TransactionRepository transactionRepository;

    public ServiceFind(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findByType(TransactionType type) {
        return transactionRepository.findByType(TransactionType type);
    }

    public List<Transaction> findByDate(String date) {
        List<Transaction> byDate = transactionRepository.findByDate(String date);
        return byDate;
    }

    public List<Transaction> findByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    public List<Transaction> findByPeriod(LocalDate startDate, LocalDate endDate) {
        return findByPeriod(LocalDate startDate, LocalDate endDate);
    }
}