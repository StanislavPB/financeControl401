package org.financecontrol401.service.validation;

public class InvalidCategoryException extends Exception{
    public InvalidCategoryException(String message) {
        super(message);
    }
}
