package org.financecontrol401.dto;
import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;

public class ClientRequestCategory {
    String categoryName;
    TransactionType categoryType;
//------------
    public ClientRequestCategory(String categoryName, TransactionType  categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public TransactionType  getCategoryType() {
        return categoryType;
    }
}
