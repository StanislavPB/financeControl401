package usermenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class usermenu {

    public class PersonalFinanceManager {
        public void userMenu(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TransactionManager transactionManager = new TransactionManager();

            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1. Ввести данные о транзакции");
                System.out.println("2. Сформировать отчет");
                System.out.println("3. Выйти");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Введите тип транзакции (доход/расход):");
                        String type = scanner.nextLine();
                        System.out.println("Введите сумму:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        System.out.println("Введите категорию:");
                        String category = scanner.nextLine();
                        System.out.println("Введите дату (гггг-мм-дд):");
                        String date = scanner.nextLine();
                        transactionManager.addTransaction(new Transaction(type, amount, category, date));
                        break;
                    case 2:
                        System.out.println("Выберите тип отчета:");
                        System.out.println("1. По дате");
                        System.out.println("2. По категории");
                        int reportChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        switch (reportChoice) {
                            case 1:
                                System.out.println("Введите дату для отчета (гггг-мм-дд):");
                                String reportDate = scanner.nextLine();
                                transactionManager.generateReportByDate(reportDate);
                                break;
                            case 2:
                                System.out.println("Введите категорию для отчета:");
                                String reportCategory = scanner.nextLine();
                                transactionManager.generateReportByCategory(reportCategory);
                                break;
                            default:
                                System.out.println("Неверный выбор.");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Программа завершена.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите существующий пункт меню.");
                        break;
                }
            }
        }
    }

    class Transaction {
        private String type;
        private double amount;
        private String category;
        private String date;

        public Transaction(String type, double amount, String category, String date) {
            this.type = type;
            this.amount = amount;
            this.category = category;
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public String getCategory() {
            return category;
        }

        public String getDate() {
            return date;
        }
    }

    class TransactionManager {
        private List<Transaction> transactions;

        public TransactionManager() {
            this.transactions = new ArrayList<>();
        }

        public void addTransaction(Transaction transaction) {
            transactions.add(transaction);
            System.out.println("Транзакция добавлена успешно.");
        }

        public void generateReportByDate(String reportDate) {
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
}