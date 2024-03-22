package org.financecontrol401.dto;

import java.util.Scanner;

public class usermenu {

    public void showMainMenu(){
        System.out.println( "Добро пожаловать, выбирите пункт меню: ");
        System.out.println( "1.Ввидите трансакцию ");
        System.out.println( "2.Сформировать отчет ");
        System.out.println( "3. Выход ");
    }
      public int choiceMenu() {
          Scanner scanner = new Scanner(System.in);
          String userchoice = scanner.nextLine();

          if (userchoice.matches("[1-3]")) {
              System.out.println("Correct");
              int n = Integer.parseInt(userchoice);
          } else {
              System.out.println("Incorrect");
          }


      }
}
