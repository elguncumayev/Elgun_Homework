package StepProjectBooking.Concretes;

import java.io.Serializable;

public class User implements Serializable {
  private String name;
  private String surname;
  private int id;
  private String gender;
  private int age;
  private static int counter = 0;

  public User(String name, String surname, String gender, int age) {
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.age = age;
    this.id = ++counter;
  }

  public static User parse(String line) {
    String[] splitted = line.split(":");
    return new User(splitted[1], splitted[2], splitted[3], Integer.parseInt(splitted[4]));
  }
}
