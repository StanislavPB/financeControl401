package org.financecontrol401.repository_test;

import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {

    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepository();
    }

    @Test
    void add() {
        // Создаем новую транзакцию
        Transaction transaction = new Transaction(TransactionType.INCOME, new Category("Категория", TransactionType.INCOME), 100.0, "Описание", LocalDate.now());

        // Добавляем транзакцию в репозиторий
        assertTrue(transactionRepository.add(transaction));
        // Проверяем, что транзакция добавлена
        assertTrue(transactionRepository.findAll().contains(transaction));
    }

    @Test
    void findByDate() {
        // Создаем несколько транзакций с разными датами
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);

        Transaction transaction1 = new Transaction(TransactionType.INCOME, new Category("Категория", TransactionType.INCOME), 100.0, "Описание", yesterday);
        Transaction transaction2 = new Transaction(TransactionType.EXPENSE, new Category("Категория", TransactionType.EXPENSE), 50.0, "Описание", today);
        Transaction transaction3 = new Transaction(TransactionType.INCOME, new Category("Категория", TransactionType.INCOME), 200.0, "Описание", tomorrow);

        transactionRepository.add(transaction1);
        transactionRepository.add(transaction2);
        transactionRepository.add(transaction3);

        // Ищем транзакции по дате
        List<Transaction> foundTransactions = transactionRepository.findByDate(today);

        // Проверяем, что найденные транзакции соответствуют заданной дате
        assertEquals(1, foundTransactions.size());
        assertEquals(today, foundTransactions.get(0).getDate());
    }


}

