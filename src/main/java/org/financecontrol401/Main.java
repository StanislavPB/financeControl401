package org.financecontrol401;

import org.financecontrol401.repository.CategoryRepository;
import org.financecontrol401.repository.TransactionRepository;
import org.financecontrol401.service.BalanceService;
import org.financecontrol401.service.CategoryService;

import org.financecontrol401.service.Menu;
import org.financecontrol401.service.TransactionService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {



        try {
            CategoryRepository categoryRepository = new CategoryRepository();
            TransactionRepository transactionRepository=new TransactionRepository();

            CategoryService categoryservice = new
                    CategoryService(categoryRepository, "src/main/resources/category.txt");

            BalanceService balanceService=new BalanceService();

            TransactionService transactionService=new
                    TransactionService( transactionRepository,
                    balanceService, "src/main/resources/transaction.txt");












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