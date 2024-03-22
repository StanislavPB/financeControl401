package org.financecontrol401.entity;

// Сущность "Баланс"
public class Balance {

    private int id; // ID
    private double amount; // Сумма

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Конструктор
    public Balance(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

}