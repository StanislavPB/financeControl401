package org.financecontrol401.service.validation;

import org.financecontrol401.entity.Category;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Request {
    // Метод для валидации типа операции
    public static void validateType(Integer type) throws Exception {
        if (type == null) {
            throw new Exception("Вы не указали тип операции");
        }

        try {
            if (type >= 3) {
                throw new Exception("Тип операции указан неверно");
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
