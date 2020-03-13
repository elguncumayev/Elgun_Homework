package StepProjectBooking.Controller;

import StepProjectBooking.Concretes.Passenger;
import StepProjectBooking.Services.Services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
  private Services service;
  private Console cc = new Console();

  public Controller() {
    service = new Services();
  }

  public String showMenu() {
    return service.getMenu();
  }

  public String allFlightsInfo() {
    return service.getAllFlightsInfo();
  }

  private String allFlightsIn24HInfo() {
   return service.getAllFlightsIn24HInfo();
  }

  public String flightByID(int id) {
    return service.getFlightByID(id);
  }

  private String bookingByID(int id) {
    return service.getBookingByID(id);
  }

  public String bookingsByPassenger(Passenger passenger) {
    return service.getBookingsByPassenger(passenger);
  }

  public String flightsFilter(String city, LocalDate date, int numOfPeople) {
    return service.searchFlightsAndGet(city, date, numOfPeople);
  }

  public void bookingOp(int flightID, List<Passenger> passengers) {
    service.bookFlight(flightID, passengers);
  }

  public Passenger newPassenger(String name, String surname) {
    return service.newPassenger(name, surname);
  }

  public void cancelBooking(int id) {
    service.cancelBooking(id);
  }


  private String lastBookinID() {
    return service.getLastBookingID();
  }

  public void case1OP() {
    cc.println(this.allFlightsIn24HInfo());
  }

  public void case2OP() {
    try {
      cc.println("Enter the flight ID or 0 to exit: ");
      String choiceOrId = cc.readline();
      if (choiceOrId.equals("0")) {
        return;
      }
      int id = Integer.parseInt(choiceOrId);
      cc.println(this.flightByID(id));
    }
    catch (NumberFormatException numberFormEx) {
      cc.println("Wrong input. Please try again.");
    }
    }

  public void case3OP() {
    while (true) {
      try {
        String city;
        LocalDate date;
        int numOfPassengers;
        cc.println("City: ");
        city = cc.readline().toLowerCase();
        cc.println("Date (YYYY-MM-DD): ");
        date = LocalDate.parse(cc.readline());
        cc.println("Number of passengers: ");
        numOfPassengers = Integer.parseInt(cc.readline());
        String currentList = this.flightsFilter(city, date, numOfPassengers);
        if (currentList.substring(0,23).equals("There is not any flight")) {
          cc.println("No matching flight.");
          return;
        }
        cc.println(currentList);
        cc.println("Please enter flight ID or 0 to exit: ");
        String choiceOrId = cc.readline();
        if (choiceOrId.equals("0")) {
          return;
        }
        int flightID = Integer.parseInt(choiceOrId);
        if (this.flightByID(flightID).substring(0, 23).equals("There is not any flight")) {
          throw new NumberFormatException();
        }
        List<Passenger> newPassengers = new ArrayList<>();
        for (int i = 0; i < numOfPassengers; i++) {
          cc.print("Passenger's name: ");
          String name = cc.readline();
          cc.print("Passenger's surname: ");
          String surname = cc.readline();
          cc.println("Saved!");
          newPassengers.add(this.newPassenger(name, surname));
        }
        this.bookingOp(flightID, newPassengers);
        cc.println("The operation successfully completed!");
        cc.println(String.format("Your ID is: %s",this.lastBookinID()));
        return;
      } catch (DateTimeParseException dateTimeEx) {
        cc.println("Your date input is not in specified order. Please try again.");
      } catch (NumberFormatException numberFormEx) {
        cc.println("Wrong input. Please try again.");
      }
    }
  }

  public void case4OP() {
    cc.println("Enter your booking ID: ");
    int id;
    try {
      id = Integer.parseInt(cc.readline());
    } catch (NumberFormatException e) {
      cc.println("Wrong input. Please try again.");
      return;
    }
    this.bookingByID(id);
    if (this.bookingByID(id).substring(0, 24).equals("There is not any booking")) {
      cc.println(this.bookingByID(id));
      return;
    }
    this.cancelBooking(id);
    cc.println("The operation successfully completed!");
  }

  public void case5OP() {
    cc.print("Enter your name: ");
    String yourname = cc.readline();
    cc.print("Enter your surname: ");
    String yoursurname = cc.readline();
    cc.println(this.bookingsByPassenger(this.newPassenger(yourname, yoursurname)));
  }
}
