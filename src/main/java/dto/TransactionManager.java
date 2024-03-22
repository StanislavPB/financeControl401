package dto;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<Transaction> transactions;
    public TransactionManager() {
        this.transactions = new ArrayList<>();
        }
        public void addTransaction(Transaction transaction) {
            transactions.add(transaction);
            System.out.println("Транзакция добавлена успешно.");
        }public void generateReportByDate(String reportDate) {
            System.out.println("Отчет по дате " + reportDate + ":");
            for (Transaction transaction : transactions) {
                if (transaction.getDate().equals(reportDate)) {
                    System.out.println("Тип: " + transaction.getType() + ", Сумма: " + transaction.getAmount() +
                            ", Категория: " + transaction.getCategory());
                }
            }
        }

        public void generateReportByCategory(String reportCategory) {
            System.out.println("Отчет по категории " + reportCategory + ":");
            for (Transaction transaction : transactions) {
                if (transaction.getCategory().equalsIgnoreCase(reportCategory)) {
                    System.out.println("Тип: " + transaction.getType() + ", Сумма: " + transaction.getAmount() +
                            ", Дата: " + transaction.getDate());
                }
            }
        }
    }

//public void showBalance() {
//    double totalIncome = 0;
//    double totalExpense = 0;
//
//    Transaction[] transactions;
//    for (Transaction transaction : transactions) {
//        if (transaction.getType().equalsIgnoreCase("доход")) {
//            totalIncome += transaction.getAmount();
//        } else if (transaction.getType().equalsIgnoreCase("расход")) {
//            totalExpense += transaction.getAmount();
//        }
//    }
//
//    double balance = totalIncome - totalExpense;
//
//    System.out.println("Общий доход: " + totalIncome);
//    System.out.println("Общий расход: " + totalExpense);
//    System.out.println("Баланс: " + balance);
//}
//}
