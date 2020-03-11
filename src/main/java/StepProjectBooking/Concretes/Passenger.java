package StepProjectBooking.Concretes;

public class Passenger {
  private String name;
  private String surname;

  public Passenger(String name,String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public static Passenger parse(String line){
    String[] splitted = line.split(":");
    return new Passenger(splitted[0],splitted[1]);
  }
}
