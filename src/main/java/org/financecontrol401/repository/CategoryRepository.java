package org.financecontrol401.repository;


import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class  CategoryRepository {
    private List<Category> categories;

    public CategoryRepository() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    /*
    public List<Category> getCategoryByType(Integer categoryType) {
        List<Category> findCategories = new ArrayList<>();
        for (Category category : categories) {
            if (category.getCategoryType().equals(categoryType)) {
                findCategories.add(category);

            }
        }
        return findCategories;
    }
*/
    public List<Category> findByType(TransactionType type) {
        List<Category> findCategories = new ArrayList<>();
        for (Category category   : categories) {
            if (category.getCategoryType() == type) {
                findCategories.add(category);
            }
        }
        return findCategories;
    }



    public Optional<Category> findByCategory(String categoryName) {

        for (Category category : categories) {
            if (category.getCategoryName().equals(categoryName)) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }

    public List<Category> findAll() {
        return categories;
    }




}


