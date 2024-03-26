package org.financecontrol401.ui;
import org.financecontrol401.dto.ClientRequestTransaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.entity.Category;

import java.time.LocalDate;
import java.util.Scanner;

public class InputReader {
    public static ClientRequestTransaction readTransaction() {
        Scanner scanner = new Scanner(System.in);

        // Ввод типа транзакции
        System.out.println("Введите тип транзакции (1 - Приход, 2 - Расход):");
        int typeValue = scanner.nextInt();
        TransactionType type = (typeValue == 1) ? TransactionType.INCOME : TransactionType.EXPENSE;

        // Ввод категории
        System.out.println("Введите название категории:");
        String categoryName = scanner.next();
        Category category = new Category(categoryName, type); // Предполагается, что тип категории соответствует типу транзакции

        // Ввод суммы
        System.out.println("Введите сумму:");
        double amount = scanner.nextDouble();

        // Ввод описания
        System.out.println("Введите описание:");
        String description = scanner.next();

        // Ввод даты
        System.out.println("Введите дату в формате гггг-мм-дд:");
        // String dateString = scanner.next();
        //LocalDate date = LocalDate.parse(dateString);
        LocalDate date=LocalDate.now();
        // Создание и возврат объекта ClientRequestTransaction
        return new ClientRequestTransaction(type, category, amount, description, date);
    }

}
