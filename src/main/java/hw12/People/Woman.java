package hw12.People;

import hw12.Services.DayOfWeek;

import java.util.ArrayList;
import java.util.Map;

public final class Woman extends Human {
  public Woman() {
    super();
  }

  public Woman(String name, String surname, long dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Woman(String name, String surname, String dateOfBirth, int iqLevel){
    super(name, surname, dateOfBirth, iqLevel);;
  }

  public Woman(String name, String surname, long dateOfBirth, int iqLevel, Map<DayOfWeek, ArrayList<String>> schedule) {
    super(name,surname,dateOfBirth,iqLevel,schedule);
  }

  public void makeUp(){
    System.out.println("A little makeup. Okay, now I look better.");
  }
}
