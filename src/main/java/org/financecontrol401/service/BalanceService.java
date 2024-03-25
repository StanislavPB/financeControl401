package org.financecontrol401.service;


import java.io.*;

public class BalanceService {
    private static final String BALANCE_FILE_PATH = "balance.txt";
    private static double balance = 0.0;

    public BalanceService() {
        loadBalanceFromCsv();
    }

    public double getBalance() {
        return balance;
    }

    public void addToBalance(double amount) {
        balance += amount;
        saveBalanceToCsv();
    }

    public void subtractFromBalance(double amount) {
        balance -= amount;
        saveBalanceToCsv();
    }

    private void saveBalanceToCsv() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BALANCE_FILE_PATH))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок записи в файл
        }
    }

    private void loadBalanceFromCsv() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BALANCE_FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                balance = Double.parseDouble(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок чтения файла
        }
    }
}


