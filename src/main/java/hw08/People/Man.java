package hw08.People;

import hw08.DayOfWeek;
import java.util.ArrayList;
import java.util.Map;

public final class Man extends Human {
  public Man() {
    super();
  }

  public Man(String name, String surname, int dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Man(String name, String surname, int dateOfBirth, int iqLevel, Map<DayOfWeek, ArrayList<String>> schedule) {
    super(name,surname,dateOfBirth,iqLevel,schedule);
  }

  public void repairCar(){
    System.out.println("There was a little problem. I got it.");
  }

}