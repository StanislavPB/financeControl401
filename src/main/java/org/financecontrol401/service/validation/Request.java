package org.financecontrol401.service.validation;

import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Request {
    // Метод для валидации типа операции
    public static void validateTransactionType(TransactionType type) throws Exception {
        try {
            if (type == null) {
                throw new Exception("Вы не указали тип операции");
            }

            // Проверяем, что тип операции является INCOME или EXPENSE
            if (type != TransactionType.INCOME && type != TransactionType.EXPENSE) {
                throw new Exception("Тип операции должен быть либо INCOME, либо EXPENSE");
            }
        } catch (Exception e) {
            throw new Exception("Произошла ошибка при валидации типа операции: " + e.getMessage());
        }
    }

    // Метод для валидации даты
    public static LocalDate validateDate(LocalDate date) throws Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.format(date); // Проверяем, соответствует ли дата заданному формату
            return date;
        } catch (Exception e) {
            throw new Exception("Некорректный формат даты. Пожалуйста, используйте формат гггг-мм-дд.");
        }
    }

    // Метод для валидации категории
    public static void validateCategory(Category category) throws Exception {
        if (category == null) {
            throw new Exception("Вы не указали категорию");
        }
    }
}
