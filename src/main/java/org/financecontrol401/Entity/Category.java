package org.financecontrol401.entity;

public class Category {

    String categoryName;
   Integer categoryType;

    public Category(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getCategoryType() {
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
