package org.financecontrol401.service.validation;

public class InvalidTransactionTypeException extends Exception{
    public InvalidTransactionTypeException(String message) {
        super(message);
    }
}

