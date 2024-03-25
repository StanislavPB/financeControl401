package org.financecontrol401.service_test;

import org.financecontrol401.service.BalanceService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BalanceServiceTest {

    // корректность добавления суммы к балансу
    @Test
    void testAddToBalance() {
        // Подготовка тестовых данных
        BalanceService balanceService = new BalanceService();
        double initialBalance = balanceService.getBalance();
        double amountToAdd = 100.0;

        // добавление суммы к балансу
        balanceService.addToBalance(amountToAdd);

        // баланс увеличился на указанную сумму
        assertEquals(initialBalance + amountToAdd, balanceService.getBalance());
    }

    // корректность вычитания суммы из баланса
    @Test
    void testSubtractFromBalance() {

        BalanceService balanceService = new BalanceService();
        double initialBalance = balanceService.getBalance();
        double amountToSubtract = 50.0;

        // вычитание суммы из баланса
        balanceService.subtractFromBalance(amountToSubtract);

        // уменьшение баланса на указанную сумму
        assertEquals(initialBalance - amountToSubtract, balanceService.getBalance());
    }
}
