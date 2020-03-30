package hw12.MainApp;

import hw12.Controller.FamilyController;

import java.util.Scanner;

public class FamilyApp {

  public void run() {
    Scanner scan = new Scanner(System.in);
    FamilyController famCon = new FamilyController();
    while(true){
      famCon.showMenu();
      String choice = scan.nextLine();
      switch (choice){
        case "1":
        famCon.caseOP1();
          break;
        case "2":
          famCon.case2OP();
          break;
        case "3":
          famCon.caseOP3();
          break;
        case "4":
          famCon.caseOP4();
          break;
        case "5":
          famCon.caseOP5();
          break;
        case "6":
          famCon.caseOP6();
          break;
        case "7":
          famCon.caseOP7();
         break;
        case "8":
          famCon.caseOP8();
          break;
        case "9":
          famCon.caseOP9();
          break;
        case "10":
          System.out.println("Good bye!");
          return;
        default:
          System.out.println("Wrong input. Try again!");
      }
    }
  }
}
