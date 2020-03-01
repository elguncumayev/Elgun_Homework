package hw08;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Pet dogg = new Pet() {
      @Override
      void respond() {
        System.out.println("WHat HAppEnS?");
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
    Human elgun = new Man("Elgun", "Jumayev", 1999, 88, elgunschedule, dog);
    System.out.println(jumayevs.countFamily());
    System.out.println(elgun);
  }
}
