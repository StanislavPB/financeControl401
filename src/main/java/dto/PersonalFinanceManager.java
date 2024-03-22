package dto;

import java.util.Scanner;

public class PersonalFinanceManager {
        public void userMenu() {
            Scanner scanner = new Scanner(System.in);
            TransactionManager transactionManager = new TransactionManager();

            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1. Ввести данные о транзакции");
                System.out.println("2. Сформировать отчет");
                System.out.println("3. Запросить баланс");
                System.out.println("4. Выйти");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Введите тип транзакции (доход/расход):");
                        String type = scanner.nextLine();
                        System.out.println("Введите сумму:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        System.out.println("Выберите категорию:");
                        if (type.equalsIgnoreCase("доход")) {
                            displayIncomeCategories();
                        } else if (type.equalsIgnoreCase("расход")) {
                            displayExpenseCategories();
                        }
                        String category = scanner.nextLine();
                        System.out.println("Введите дату (дд-мм-гггг):");
                        String date = scanner.nextLine();
                        transactionManager.addTransaction(new Transaction(type, amount, category, date));
                        break;
                    case 2:
                        System.out.println("Выберите тип отчета:");
                        System.out.println("1. По дате");
                        System.out.println("2. По категории");
                        System.out.println("3. По сумме");
                        int reportChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        switch (reportChoice) {
                            case 1:
                                System.out.println("Введите дату для отчета (дд-мм-гггг):");
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
//                    case 3:
//                        transactionManager.showBalance();
//                        break;
                    case 4:
                        System.out.println("Программа завершена.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите существующий пункт меню.");
                        break;
                }
            }
        }

    // Метод для отображения категорий расходов
    private static void displayExpenseCategories() {
        System.out.println("Выберите категорию:");
        System.out.println("1. Продукты");
        System.out.println("2. Одежда");
        System.out.println("3. Комуналка");
        System.out.println("4. Аренда");
        System.out.println("5. Транспорт");
        System.out.println("6. Досуг");
        System.out.println("7. Здоровье");
    }

    // Метод для отображения категорий доходов
    private static void displayIncomeCategories() {
        System.out.println("Выберите категорию:");
        System.out.println("1. Зарплата");
        System.out.println("2. Депозиты");
        System.out.println("3. Дополнительный доход");
    }
}

