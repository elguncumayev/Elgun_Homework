package StepProjectBooking.Concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {
  private int id;
  private String destination;
  private LocalDateTime dateTime;
  private LocalDate date;
  private int emptySeats;
  private static int counter = 0;

  public Flight(String destination, LocalDateTime time, int emptySeats) {
    this.destination = destination;
    this.dateTime = time;
    this.emptySeats = emptySeats;
    this.id = ++counter;
    this.date = time.toLocalDate();
  }

  private Flight(int id,String destination, LocalDateTime dateTime, int emptySeats){
    this.destination = destination;
    this.dateTime = dateTime;
    this.emptySeats = emptySeats;
    this.id = id;
    this.date = dateTime.toLocalDate();
  }
  public String getDestination() {
    return this.destination;
  }

  public LocalDateTime getDateTime() {
    return this.dateTime;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public int getEmptySeats() {
    return this.emptySeats;
  }

  public int getId() {
    return this.id;
  }

  public String represent() {
    return String.format("%s %s %s %s", this.getId(), this.getDestination(), this.getDateTime(), this.getEmptySeats());
  }

  public static Flight parse(String line) {
    String[] splitted = line.split(";");
    return new Flight(Integer.parseInt(splitted[0]),splitted[1], LocalDateTime.parse(splitted[2]), Integer.parseInt(splitted[3]));
  }
}
