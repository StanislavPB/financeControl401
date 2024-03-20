package org.financecontrol401.Entity;

import java.util.Date;


public class Transaction {
    private int idTransaction=0;
    private String type;
    private String category;
    private double amount;
    private String Description;

    private Date date;

    public Transaction(String type, String category, double amount, String description, Date date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        Description = description;
        this.date = date;

    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDate() {
        return date;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", Description='" + Description + '\'' +
                ", date=" + date +
                '}';
    }
}

