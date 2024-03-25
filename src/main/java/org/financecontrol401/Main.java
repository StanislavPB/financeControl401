package org.financecontrol401;

import repository.CategoryRepository;
import service.CategoryService;
import service.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        CategoryRepository categoryRepository = new CategoryRepository();
        try {
            CategoryService categoryservice = new
                    CategoryService(categoryRepository, "D:\\TXT\\category.txt");
            Menu menu = new Menu(categoryservice);

            menu.displayMainMenu();
            int operationType = menu.getUserChoice();

            menu.displayCategoryMenu(operationType);
            int categoryChoice = menu.getUserChoice();

        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок записи в файл
        }


    }
}