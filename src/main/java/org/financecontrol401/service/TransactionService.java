package org.financecontrol401.service;

import dto.ClientRequestTransaction;
import entity.Category;
import entity.Transaction;
import entity.TransactionType;
import repository.TransactionRepository;

import java.io.*;
import java.time.LocalDate;

public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final BalanceService balanceService;
    private String filePath;

    public TransactionService(TransactionRepository transactionRepository,
                              BalanceService balanceService, String filePath)
            throws IOException    {
        this.transactionRepository = transactionRepository;
        this.balanceService = balanceService;
        this.filePath = filePath;
        this.loadTransactionsFromCSV();

    }
    public void loadTransactionsFromCSV() {
        //throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String typeString = parts[0].trim();
                    TransactionType type;
                    if (typeString.equals("1")) {
                        type = TransactionType.INCOME;
                                      } else if (typeString.equals("2")) {
                        type = TransactionType.EXPENSE;
                    } else {
                        // Обработка ошибки при неверном значении типа транзакции
                        System.err.println("Ошибка при чтении файла CSV: Неверное значение типа транзакции");
                        continue; // Пропускаем эту строку и переходим к следующей
                    }
                    double amount = Double.parseDouble(parts[1].trim());
                    Category category = new Category(parts[2].trim(), null); // Здесь null, так как ID категории может быть пустым, если категория еще не добавлена
                    String description = parts[3].trim();
                    LocalDate date = LocalDate.parse(parts[4].trim());
                    ClientRequestTransaction requestTransaction =
                            new ClientRequestTransaction(type, category, amount, description,
                                    date);
                    Transaction transaction = mapToTransaction(requestTransaction);
                    transactionRepository.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок чтения из файла
        }
    }

    private void updateBalance(Transaction transaction) {
        if (transaction.getType() == TransactionType.INCOME) {
            balanceService.addToBalance(transaction.getAmount());
        } else if (transaction.getType() == TransactionType.EXPENSE) {
            balanceService.subtractFromBalance(transaction.getAmount());
        }
    }

    private Transaction mapToTransaction(ClientRequestTransaction requestTransaction) {
        return new Transaction(requestTransaction.getType(),
                requestTransaction.getCategory(),
                requestTransaction.getAmount(), requestTransaction.getDescription(),
                requestTransaction.getDate());
    }

    public void addTransaction(ClientRequestTransaction requestTransaction) {
        Transaction transaction = mapToTransaction(requestTransaction);
        transactionRepository.add(transaction);
        updateBalance(transaction);
        saveToCsv();
    }

    private void saveToCsv() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(this.filePath))) {
            for (Transaction transaction : transactionRepository.findAll()) {
                String typeString;
                if (transaction.getType() == TransactionType.INCOME) {
                    typeString = "1";
                } else if (transaction.getType() == TransactionType.EXPENSE) {
                    typeString = "2";
                } else {
                    // Обработка ошибки при неверном значении типа транзакции
                    System.err.println("Ошибка при записи в файл CSV: Неверное значение типа транзакции");
                    continue; // Пропускаем эту транзакцию и переходим к следующей
                }
                String csvLine = typeString + ";" +
                        transaction.getAmount() + ";" +
                        transaction.getCategory().getCategoryName() + ";" +
                        transaction.getDescription() + ";" +
                        transaction.getDate().toString() + "\n";
                writer.write(csvLine);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок записи в файл
        }
    }

}