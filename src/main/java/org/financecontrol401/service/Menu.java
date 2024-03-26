package org.financecontrol401.service;

import org.financecontrol401.dto.ClientRequestTransaction;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.ui.InputReader;
import java.util.Scanner;
import java.util.List;

public class Menu {
    private final TransactionService transactionService;
    private final FindService findService;

    public Menu(TransactionService transactionService, FindService findService) {
        this.transactionService = transactionService;
        this.findService = findService;
    }

    public void displayMainMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Ввод новой операции");
        System.out.println("2. Вывод списка операций");
        System.out.println("0. Выход");
    }

    public void processUserChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewTransaction();
                    break;
                case 2:
                    displayTransactions();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void addNewTransaction() {
        ClientRequestTransaction requestTransaction = InputReader.readTransaction();
        transactionService.addTransaction(requestTransaction);
    }

    private void displayTransactions() {
        List<Transaction> transactionList = findService.findAll();
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }

    }
}
