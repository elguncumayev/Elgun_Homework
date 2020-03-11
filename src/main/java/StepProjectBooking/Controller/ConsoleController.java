package StepProjectBooking.Controller;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleController {
  private static Scanner scanner = new Scanner(System.in);
  private static String string;
  public String input(){
    string = scanner.nextLine();
    return string;
  }
  public void println(String line){
    System.out.println(line);
  }
  public void print(String line){
    System.out.print(line);
  }
}
