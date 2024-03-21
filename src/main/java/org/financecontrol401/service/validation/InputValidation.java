package org.financecontrol401.service.validation;

import org.financecontrol401.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
//    // Метод для валидации даты
//    public static Date validateDate (Date date) throws Exception {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            dateFormat.setLenient(false);
//            return date;
//        } catch (Exception e) {
//            throw new Exception("Некорректный формат даты. Пожалуйста, используйте формат гггг-мм-дд.");
//        }
//    }

    public List<String> errors(Transaction transaction) {

        List<String> errorMessages = new ArrayList<>();

        if (transaction.getType() == null) {
            errorMessages.add("Вы не указали тип операции");
        }

        if (transaction.getType() >= 3) {
            errorMessages.add("Тип операции указан не верно");
        }

        if (transaction.getCategory().equals("")) {
            errorMessages.add("Вы не указали категорию");
        }

        return errorMessages;
    }
}




