package StepProjectBooking.Controller;

import StepProjectBooking.Controller.Controller;

import java.util.Scanner;

public class BookingAPP {
  public void run(){
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    int menuChoice;
    while (true){
      controller.showMenu();
      menuChoice = scanner.nextInt();
      switch (menuChoice){
        case 1:
          controller.allInfo();
          break;
        case 2:
          int Id = scanner.nextInt();
          controller.byID(Id);
          break;
        case 3:break;
        case 4:break;
        case 5:break;
        case 6:
          System.out.println("Good bye!");
          break;
        default:
          System.out.println("Wrong Input. Please try again.");
      }
    }
  }
}
