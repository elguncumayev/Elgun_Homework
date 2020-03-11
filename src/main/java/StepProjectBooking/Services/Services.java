package StepProjectBooking.Services;

import StepProjectBooking.Concretes.Booking;
import StepProjectBooking.Concretes.Flight;
import StepProjectBooking.Concretes.Passenger;
import StepProjectBooking.DAO.DAO;
import StepProjectBooking.DAO.DAOFlightFile;
import StepProjectBooking.DAO.DAOBookingFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Services {
  private DAO<Flight> daoMain = new DAOFlightFile();
  //private DAO<User> daoUser = new DAOUserFile();
  private DAO<Booking> daoBooking = new DAOBookingFile();

  public Services() throws FileNotFoundException {
  }

  public String getMenu() {
    StringBuilder sB = new StringBuilder();
    sB.append("1. **Online-board**\n")
            .append("2. **Show the flight info**\n")
            .append("3. **Search and book a flight**\n")
            .append("4. **Cancel the booking**\n")
            .append("5. **My flights**\n")
            .append("6. **Exit**");
    return sB.toString();
  }

  public List<String> getAllFlightsInfo() throws FileNotFoundException {
    Collection<Flight> all = daoMain.getAll();
    return all.stream().map(Flight::represent).collect(Collectors.toList());
  }

  public String getFlightByID(int id) throws FileNotFoundException {
    return daoMain.getById(id)
            .map(Flight::represent)
            .orElse(String.format("There is not any flight with this ID: %d", id));
  }

  public List<String> searchFlightsAndGet(String city, LocalDate date, int numOfPeople) throws FileNotFoundException {
    return daoMain.getAll().stream()
            .filter(flight -> (flight.getDestination().equals(city) && flight.getDate().equals(date) && flight.getEmptySeats() >= numOfPeople))
            .map(Flight::represent).collect(Collectors.toList());
  }

  public void bookFlight(int id, List<Passenger> passengers) throws IOException {
    Booking booking = new Booking(id, passengers);
    daoBooking.saveChanges(booking);
    daoMain.saveChanges(daoMain.getById(id).orElse(new Flight("Nowhere", LocalDateTime.parse("0001-01-01T00:01"), 0, 0)));
  }

  public Passenger newPassenger(String name, String surname) {
    return new Passenger(name, surname);
  }

  public void cancelBooking(int id, Passenger passenger) throws FileNotFoundException {
      Booking booking = daoBooking.getById(id).orElseThrow(FileNotFoundException::new).getPassengerList().remove(passenger);
  }
}
