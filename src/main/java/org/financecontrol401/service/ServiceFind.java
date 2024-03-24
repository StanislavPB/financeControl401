package org.financecontrol401.service;

import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.*;

// Сервис для поиска транзакций
public class ServiceFind {
    private final TransactionRepository transactionRepository;
    private LocalDate startDate;

    public ServiceFind(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }

    public List<Transaction> findByDate(String date) {
        List<Transaction> byDate = transactionRepository.findByDate(parse(date));
        return byDate;
    }

    public List<Transaction> findByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    public List<Transaction> findByPeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        return transactionRepository.findByPeriod(startDate, endDate);
    }
}
