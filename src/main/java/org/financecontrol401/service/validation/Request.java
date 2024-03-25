package org.financecontrol401.service.validation;

import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Request {
    // Метод для валидации типа операции
    public static void validateTransactionType(TransactionType type) throws java.lang.Exception {
        try {
            if (type == null) {
                throw new java.lang.Exception("Вы не указали тип операции");
            }

            // Проверяем, что тип операции является INCOME или EXPENSE
            if (type != TransactionType.INCOME && type != TransactionType.EXPENSE) {
                throw new java.lang.Exception("Тип операции должен быть либо INCOME, либо EXPENSE");
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.Exception("Произошла ошибка при валидации типа операции: " + e.getMessage());
        }
    }

    // Метод для валидации даты
    public static LocalDate validateDate(LocalDate date) throws java.lang.Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.format(date); // Проверяем, соответствует ли дата заданному формату
            return date;
        } catch (java.lang.Exception e) {
            throw new java.lang.Exception("Некорректный формат даты. Пожалуйста, используйте формат гггг-мм-дд.");
        }
    }

    // Метод для валидации категории
    public static void validateCategory(Category category) throws java.lang.Exception {
        if (category == null) {
            throw new java.lang.Exception("Вы не указали категорию");
        }
    }
}
