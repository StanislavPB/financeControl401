package org.financecontrol401.dto;

import entity.Category;
import entity.TransactionType;

import java.time.LocalDate;

public class ClientRequestTransaction {

    private TransactionType type;
    private Category category;
    private double amount;
    private String Description;

    private LocalDate date;


    //---------------------

    public ClientRequestTransaction(TransactionType type, Category category,
                                    double amount, String description, LocalDate date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        Description = description;
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return Description;
    }

    public LocalDate getDate() {
        return date;
    }
}
