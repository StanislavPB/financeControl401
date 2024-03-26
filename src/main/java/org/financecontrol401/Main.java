package org.financecontrol401;

import org.financecontrol401.dto.ClientRequestTransaction;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.CategoryRepository;
import org.financecontrol401.repository.TransactionRepository;
import org.financecontrol401.service.*;

import org.financecontrol401.ui.InputReader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

            FindService findService=new FindService(transactionRepository);

            Menu menu = new Menu(transactionService, findService);
            menu.processUserChoice();

/*

//Ввод--------------------------------------
            ClientRequestTransaction requestTransaction = InputReader.readTransaction();

            transactionService.addTransaction(requestTransaction);


//===================================

            //Вывод


            FindService findService=new FindService(transactionRepository);

            List<Transaction> findetlist= findService.findAll();
            //System.out.println(findetlist);

            LocalDate startDate = LocalDate.of(2023, 1, 1);
            LocalDate endDate = LocalDate.of(2024, 4, 1);
            TransactionType type = TransactionType.INCOME;

            // Вызываем метод findByTypeAndPeriod и получаем список транзакций
            List<Transaction> findetlist2 =
                    findService.findByTypeAndPeriod(startDate, endDate, type);

            // Выводим найденные транзакции
            System.out.println("Найденные транзакции:");
            for (Transaction transaction : findetlist2) {
                System.out.println(transaction); // Предполагается, что у класса Transaction переопределен метод toString()
            }




/*

            Menu menu = new Menu(categoryservice);

            menu.displayMainMenu();
            int operationType = menu.getUserChoice();

            menu.displayCategoryMenu(operationType);
            int categoryChoice = menu.getUserChoice();
*/


        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок записи в файл
        }


    }
}