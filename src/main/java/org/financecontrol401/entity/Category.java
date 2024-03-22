package org.financecontrol401.entity;
// Сущность "Категория"
public class Category {

    private int id; // ID
    private String name; // Название

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Конструктор
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

}