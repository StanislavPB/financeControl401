package org.financecontrol401.service.validation;

import org.financecontrol401.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {

    public List<String> errors(Transaction transaction) {

        List<String> errorMessages = new ArrayList<>();

        if (transaction.getType() == null) {
            errorMessages.add("Вы не указали тип операции");
        }


        if (transaction.getDate() == null) {
            errorMessages.add("Вы не указали дату");
        }


        if (transaction.getCategory().equals("")) {
            errorMessages.add("Вы не указали категорию");
        }
        return errorMessages;
    }
}




