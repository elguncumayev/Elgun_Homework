package hw07;

import hw07.Animal.Dog;
import hw07.Animal.Pet;

public class Main {
  public static void main(String[] args) {
    Pet dogg = new Pet() {
      @Override
      public void respond() {
        System.out.println("WHat HAppEnS?");
      }

      @Override
      protected void foul() {

      }
    };
    System.out.println(dogg.species);
    Human mother = new Woman();
    Human father = new Man();
    Family jumayevs = new Family(father, mother);
    Pet dog = new Dog("dognickname", 3, 45, new String[]{"doghabit1", "doghabit2"});
    System.out.println(dog.species);
    //Human elgun = new Man("Elgun", "Jumayev", 1999, 88, elgunschedule, dog);
    System.out.println(jumayevs.countFamily());
    //System.out.println(elgun);
  }
}
