package org.financecontrol401.service;


import org.financecontrol401.dto.TransactionDto;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.repository.TransactionRepository;

// Сервис для добавления и обновления транзакций
// Сервис для добавления и обновления транзакций
public class ServiceAddOrUpdate {
    private final TransactionRepository transactionRepository;

    public ServiceAddOrUpdate(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void add(TransactionDto transactionDto) {
        // Валидация данных
        validateTransaction(transactionDto);

        // Преобразование DTO в Entity
        Transaction transaction = new Transaction();
        transaction.setDate(transactionDto.getDate());
        transaction.setType(transactionDto.getType());
        transaction.setCategory(transactionDto.getCategory());
        transaction.setAmount(transactionDto.getAmount());

        // Сохранение транзакции в базе данных
        transactionRepository.save(transaction);
    }

    public void update(Long id, TransactionDto transactionDto) {
        // Валидация данных
        validateTransaction(transactionDto);

        // Получение транзакции из базы данных
        Transaction transaction = transactionRepository.findById(id).orElseThrow();

        // Обновление данных транзакции
        transaction.setDate(transactionDto.getDate());
        transaction.setType(transactionDto.getType());
        transaction.setCategory(transactionDto.getCategory());
        transaction.setAmount(transactionDto.getAmount());

        // Сохранение обновленной транзакции
        transactionRepository.save(transaction);
    }

    private void validateTransaction(TransactionDto transactionDto) {
        // TODO: Реализация валидации
    }
}
