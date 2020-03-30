package hw12.People;

import hw12.Services.DayOfWeek;

import java.util.ArrayList;
import java.util.Map;

public final class Man extends Human {
  public Man() {
    super();
  }

  public Man(String name, String surname, long dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Man(String name, String surname, String dateOfBirth, int iqLevel){
    super(name, surname, dateOfBirth, iqLevel);;
  }

  public Man(String name, String surname, long dateOfBirth, int iqLevel, Map<DayOfWeek, ArrayList<String>> schedule) {
    super(name,surname,dateOfBirth,iqLevel,schedule);
  }

  public void repairCar(){
    System.out.println("There was a little problem. I got it.");
  }

}