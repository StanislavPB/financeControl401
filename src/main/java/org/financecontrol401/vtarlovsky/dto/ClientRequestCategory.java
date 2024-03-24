package org.financecontrol401.vtarlovsky.dto;

public class ClientRequestCategory {
    String categoryName;
    Integer categoryType;
//------------
    public ClientRequestCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }
}
