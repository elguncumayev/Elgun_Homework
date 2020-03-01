package hw08;

import java.util.ArrayList;
import java.util.Map;

public final class Woman extends Human {
  public Woman() {
    super();
  }

  public Woman(String name, String surname, int dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Woman(String name, String surname, int dateOfBirth, int iqLevel, Map<DayOfWeek, ArrayList<String>> schedule, Pet pet) {
    super(name,surname,dateOfBirth,iqLevel,schedule,pet);
  }

  public void makeUp(){
    System.out.println("A little makeup. Okay, now I look better.");
  }

  @Override
  void greetPet() {
    System.out.printf("Hello, %s.\n. You look good.", this.pet.getNickname());
  }
}
