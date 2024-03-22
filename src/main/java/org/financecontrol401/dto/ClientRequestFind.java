package org.financecontrol401.dto;

// DTO для запроса поиска от пользователя
public class ClientRequestFind {

    private String startDate; // Начальная дата
    private String endDate; // Конечная дата
    private String category; // Категория

    // Геттеры и сеттеры
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Конструктор
    public ClientRequestFind(String startDate, String endDate, String category) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }

}
