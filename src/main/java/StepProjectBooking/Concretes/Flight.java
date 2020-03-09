package StepProjectBooking.Concretes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
  public int id;
  public String destination;
  public LocalDate date;
  public LocalTime time;
  public int emptySeats;

  public Flight parse(String line){
      line.split("|");
  }
}
