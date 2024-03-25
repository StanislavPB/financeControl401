package org.financecontrol401.entity;

public class Category {
    String categoryName;
    TransactionType categoryType;

    public Category(String categoryName, TransactionType categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public TransactionType getCategoryType() {
        return categoryType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
