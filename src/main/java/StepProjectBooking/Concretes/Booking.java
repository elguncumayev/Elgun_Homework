package StepProjectBooking.Concretes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Booking {
  private int ID;
  private List<Passenger> passengerList;

  public Booking(int id,List<Passenger> passengerList){
    this.ID = id;
    this.passengerList = passengerList;
  }

  public int getID() {
    return ID;
  }

  public List<Passenger> getPassengerList() {
    return passengerList;
  }

  public List<Passenger> union(List<Passenger> that){
    List<Passenger> passengers = new ArrayList<>(this.getPassengerList());
    passengers.addAll(that);
    return passengers;
  }

  public static Booking parse(String line){
    String[] splitted = line.split("#");
    int id = Integer.parseInt(splitted[0]);
    String[] splitted2 = splitted[1].split(";");
    List<Passenger> collected = Arrays.stream(splitted2).map(Passenger::parse).collect(Collectors.toList());
    return new Booking(id,collected);
  }
  public String fileFormat(){
    StringBuilder sb = new StringBuilder();
    sb.append(this.getID())
            .append("#");
    for (Passenger passenger : this.getPassengerList()) {
      sb.append(passenger.getName())
              .append(":")
              .append(passenger.getSurname())
              .append(";");
    }
    return sb.toString();
  }

}
