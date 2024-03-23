package org.financecontrol401.entity;

// Сущность "Транзакция"
public class Transaction {

    private int id; // ID
    private String type; // Тип операции (доход/расход)
    private Category category; // Категория
    private String date; // Дата
    private double amount; // Сумма

    public Transaction() {

    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
    public Transaction(int id, String type, Category category, String date, double amount) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.date = date;
        this.amount = amount;
    }


}