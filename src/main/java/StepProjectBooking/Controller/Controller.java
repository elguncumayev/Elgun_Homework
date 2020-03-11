package StepProjectBooking.Controller;

import StepProjectBooking.Concretes.Passenger;
import StepProjectBooking.Concretes.User;
import StepProjectBooking.Services.Services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Controller {
  private Services service;

  public Controller() {
    service = new Services();
  }

  public String showMenu() {
    return service.getMenu();
  }

  public String allFlightsInfo() throws FileNotFoundException {
    return service.getAllFlightsInfo().toString();
  }

  public String flightByID(int id) throws FileNotFoundException {
    return service.getFlightByID(id);
  }

  public String flightsByUser(String namesurname) {
throw new IllegalArgumentException("flightByUser not implemented!!!");
  }

  public List<String> flightsFilter(String city, LocalDate date, int numOfPeople) throws FileNotFoundException {
    return service.searchFlightsAndGet(city,date,numOfPeople);
  }

  public void bookingOp(int id, List<Passenger> passengers) throws IOException {
    service.bookFlight(id,passengers);
  }

  public Passenger newPassenger(String name, String surname) {
    return service.newPassenger(name,surname);
  }
}
