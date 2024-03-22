package org.financecontrol401.dto;
// DTO для ответа пользователю
public class ClientResponse {

    private String message; // Сообщение

    // Геттеры и сеттеры
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Конструктор
    public ClientResponse(String message) {
        this.message = message;
    }

}