package hw08;

import hw08.Animal.Dog;
import hw08.Animal.Pet;
import hw08.People.Family;
import hw08.People.Human;
import hw08.People.Man;
import hw08.People.Woman;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Pet dogg = new Pet() {
      @Override
      protected void respond() {
        System.out.println("WHat HAppEnS?");
      }
      @Override
      protected void foul() {
        System.out.println("I need to cover it up");
      }
    };
    System.out.println(dogg.species);
    HashMap<DayOfWeek, ArrayList<String>> elgunschedule = new HashMap<>();
    elgunschedule.put(DayOfWeek.MONDAY, new ArrayList<>(Arrays.asList("go to course", "write clean code")));
    Human mother = new Woman();
    Human father = new Man();
    Family jumayevs = new Family(father, mother);
    Pet dog = new Dog("dognickname", 3, 45, new HashSet<>(Arrays.asList("doghabit1", "doghabit2")));
    System.out.println(dog.species);
    Human elgun = new Man("Elgun", "Jumayev", 1999, 88, elgunschedule);
    System.out.println(jumayevs.countFamily());
    System.out.println(elgun);
  }
}
