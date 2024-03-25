package org.financecontrol401.dto;
// DTO для запроса от пользователя
public class ClientRequest {
//--------------------
    private String type; // Тип операции (доход/расход)
    private String category; // Категория операции
    private String date; // Дата операции
    private double amount; // Сумма операции

    // Геттеры и сеттеры
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Конструктор
    public ClientRequest(String type, String category, String date, double amount) {
        this.type = type;
        this.category = category;
        this.date = date;
        this.amount = amount;
    }

}