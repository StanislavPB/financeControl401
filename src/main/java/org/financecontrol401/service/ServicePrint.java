package org.financecontrol401.service;
// Сервис для печати информации о транзакциях
public class ServicePrint {
    public void printAll(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void printByDate(List<Transaction> transactions) {
        // TODO: Реализация печати по дате
    }

    public void printByCategory(List<Transaction> transactions) {
        // TODO: Реализация печати по категории
    }
}
