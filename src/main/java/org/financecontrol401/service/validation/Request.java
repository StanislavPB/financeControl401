package org.financecontrol401.service.validation;

import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Request {
    // Метод для валидации типа операции
    public static void validateTransactionType(TransactionType type) throws InvalidTransactionTypeException {
        if (type == null) {
            throw new InvalidTransactionTypeException("Вы не указали тип операции");
        }

        // Проверяем, что тип операции является INCOME или EXPENSE
        if (!type.equals(TransactionType.INCOME) && !type.equals(TransactionType.EXPENSE)) {
            throw new InvalidTransactionTypeException("Тип операции должен быть либо INCOME, либо EXPENSE");
        }
    }
    // Метод для валидации даты
    public static LocalDate validateDate(String date) throws InvalidDateFormatException {
        try {
            return LocalDate.parse(date);
        } catch (java.time.format.DateTimeParseException e) {
            throw new InvalidDateFormatException("Некорректный формат даты. Пожалуйста, используйте формат гггг-мм-дд.");
        }
    }

    // Метод для валидации категории
    public static void validateCategory(Category category) throws InvalidCategoryException {
        if (category == null) {
            throw new InvalidCategoryException("Вы не указали категорию");
        }
    }
}
