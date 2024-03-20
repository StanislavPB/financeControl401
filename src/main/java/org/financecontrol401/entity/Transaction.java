package org.financecontrol401.entity;

import java.time.LocalDate;



public class Transaction {
    private int idTransaction=0;
    private TransactionType type;
    private Category category;
    private double amount;
    private String Description;

    private LocalDate date;

    public Transaction(TransactionType type, Category category, double amount, String description,
                       LocalDate date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        Description = description;
        this.date = date;
    }

    public int getIdTransaction() {
        return idTransaction;
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

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", type=" + type +
                ", category=" + category +
                ", amount=" + amount +
                ", Description='" + Description + '\'' +
                ", date=" + date +
                '}';
    }
}



