package org.financecontrol401.service;


import java.io.*;

public class BalanceService {
    private static final String BALANCE_FILE_PATH = "src/main/resources/balance.txt";
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


//Инициализация пути к файлу и переменной баланса: Код начинается с определения пути к файлу (BALANCE_FILE_PATH),
// в котором будет храниться текущий баланс, и переменной balance, которая содержит текущее значение баланса.
//Конструктор BalanceService: При создании объекта BalanceService вызывается конструктор.
//Внутри конструктора вызывается метод loadBalanceFromCsv(), который загружает текущее значение баланса из файла.
//Метод getBalance(): Этот метод возвращает текущее значение баланса.
//
//Методы addToBalance() и subtractFromBalance(): Эти методы используются для добавления или вычитания указанной суммы из текущего баланса соответственно.
//После изменения баланса вызывается метод saveBalanceToCsv(), который сохраняет новое значение баланса в файл.
//Приватные методы saveBalanceToCsv() и loadBalanceFromCsv():
//
//saveBalanceToCsv(): Записывает текущее значение баланса в файл.
//loadBalanceFromCsv(): Загружает текущее значение баланса из файла. Если файл не существует или не удалось его прочитать, используется начальное значение баланса (0.0).
//Этот код, в основном, реализует простой сервис управления балансом. Он загружает начальное значение баланса из файла при инициализации и позволяет добавлять или вычитать суммы из баланса, автоматически сохраняя изменения обратно в файл.