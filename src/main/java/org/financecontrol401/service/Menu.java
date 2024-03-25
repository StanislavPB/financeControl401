package org.financecontrol401.service;

import entity.Category;
import entity.TransactionType;

import java.util.List;
import java.util.Scanner;

public class Menu {

    /*
    private final CategoryRepository categoryRepository;

    public Menu(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
*/
    private final CategoryService categoryService;

    public Menu(CategoryService categoryService) {
        this.categoryService = categoryService;
    }




    public void displayMainMenu() {
        System.out.println("Выберите тип операции:");
        System.out.println("1. Приход");
        System.out.println("2. Расход");
    }

    public void displayCategoryMenu(int operation) {
    TransactionType operationType = null;
    if (operation == 1) {
        operationType = TransactionType.INCOME;
    } else if (operation == 2) {
        operationType = TransactionType.EXPENSE;
    }

    if (operationType != null) {
        List<Category> categories = categoryService.findByType(operationType);
        System.out.println("Выберите категорию:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
    } else {
        System.out.println("Ошибка: неверный тип операции.");
    }
}

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }



}
