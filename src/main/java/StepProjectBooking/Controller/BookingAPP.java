package StepProjectBooking.Controller;

import StepProjectBooking.Concretes.Passenger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingAPP {
  public void run() throws IOException {
    Controller controller = new Controller();
    ConsoleController cc = new ConsoleController();
    while (true) {
      cc.println(controller.showMenu());
      String menuChoice = cc.input();
      switch (menuChoice) {
        case "1":
          cc.println(controller.allFlightsInfo());
          break;

        case "2":
          cc.println("Enter the flight ID: ");
          int Id = Integer.parseInt(cc.input());
          cc.println(controller.flightByID(Id));
          break;
        case "3":
          String city;
          LocalDate date;
          int numOfPeople;

          cc.println("City: ");
          city = cc.input();

          cc.println("Date (YYYY-MM-DD): ");
          date = LocalDate.parse(cc.input());

          cc.println("Number of passengers: ");
          numOfPeople = Integer.parseInt(cc.input());

          List<String> flightsFilter = controller.flightsFilter(city, date, numOfPeople);
          if (flightsFilter.isEmpty()) {
            cc.println("No matching flight.");
            break;
          }

          cc.println(flightsFilter.toString());
          cc.println("Please enter flight ID or 0 to exit: ");

          String choice = cc.input();
          if (choice.equals("0")) {
            break;
          }
          int id = Integer.parseInt(choice);
          List<Passenger> passengers = new ArrayList<>();
          for (int i = 0; i < numOfPeople; i++) {
            cc.print("Passenger's name: ");
            String name = cc.input();
            cc.print("Passenger's surname: ");
            String surname = cc.input();
            cc.println("Saved!");
            passengers.add(controller.newPassenger(name,surname));
          }
          controller.bookingOp(id,passengers);
          cc.println("The operation successfully completed!");
          break;

        case "4":
          cc.println("Enter your booking ID: ");
          int bookingID = Integer.parseInt(cc.input());
          cc.println("Enter your name: ");
          String passengerName = cc.input();
          cc.println("Enter your surname: ");
          String passengerSurname = cc.input();
          controller.cancelBooking(bookingID,controller.newPassenger(passengerName,passengerSurname));
          break;
        case "5":
//          System.out.println("Enter name and surname: ");
//          String namesurname = scanner.nextLine();
//          controller.flightsByUser(namesurname);
          break;
        case "6":
          cc.println("Good bye!");
          break;
        default:
          cc.println("Wrong Input. Please try again.");
      }
//      System.out.println("Press enter to continue...");
//      int read = System.in.read();
    }
  }
}
