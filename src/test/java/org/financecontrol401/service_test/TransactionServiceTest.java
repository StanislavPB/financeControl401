package org.financecontrol401.service_test;

import org.financecontrol401.dto.ClientRequestTransaction;
import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.TransactionRepository;
import org.financecontrol401.service.BalanceService;
import org.financecontrol401.service.TransactionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.time.LocalDate;

public class TransactionServiceTest {

    // корректность добавления транзакции
    @Test
    void testAddTransaction() throws IOException {

        TransactionRepository transactionRepository = new TransactionRepository();
        BalanceService balanceService = new BalanceService();
        String filePath = "test_transactions.csv";
        TransactionService transactionService = new TransactionService(transactionRepository, balanceService, filePath);
        ClientRequestTransaction requestTransaction = new ClientRequestTransaction(TransactionType.INCOME,
                new Category("Test", TransactionType.INCOME), 100.0, "Test transaction", LocalDate.now());

        // добавление транзакции
        transactionService.addTransaction(requestTransaction);

        // список транзакций не пустой после добавления
        assertTrue(transactionRepository.findAll().size() > 0);
    }
}
