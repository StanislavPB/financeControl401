package org.financecontrol401.service;
// Сервис для поиска транзакций
public class ServiceFind {
    private final TransactionRepository transactionRepository;

    public ServiceFind(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findByDate(String date) {
        return transactionRepository.findByDate(date);
    }

    public List<Transaction> findByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    public List<Transaction> findByDateAndCategory(String date, String category) {
        return transactionRepository.findByDateAndCategory(date, category);
    }
}