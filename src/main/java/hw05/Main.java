package hw05;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Human johnSmith = new Human("John", "Smith", 1973);

    String[] aliceDogHabits = {"sleep", "play"};
    Pet aliceDog = new Pet("Dog", "Marshmallow", 3, 68, aliceDogHabits);
    Human aliceSmith = new Human("Alice", "Smith", 1975);

    Family smiths = new Family(johnSmith, aliceSmith);

    Pet oliviaCat = new Pet("Cat", "Puffy");
    Human oliviaSmith = new Human("Olivia", "Smith", 1996);

    Pet davidDog = new Pet();
    String[][] davidSchedule = {{"Sunday", "do homework"}, {"Monday", "go to course"}};
    Human davidSmith = new Human("David", "Smith", smiths, 1998, 88, davidSchedule, davidDog);
    System.out.println(oliviaSmith.getFamily());
    smiths.addChild(oliviaSmith);
    smiths.addChild(davidSmith);
    System.out.println(smiths.countFamily());
    smiths.deleteChild(oliviaSmith);
    System.out.println(smiths.countFamily());
    System.out.println(oliviaSmith.getFamily());
    davidDog.setSpecies("Dog");
    davidDog.setNickname("Rocky");
    davidDog.setAge(4);
    davidDog.setTrickLevel(48);
    davidDog.setHabits(new String[]{"run", "play"});
    System.out.println(davidSmith.toString());
    davidSmith.greetPet();
    davidSmith.describePet();
    System.out.println(aliceDog.toString());
    aliceDog.respond();
    aliceDog.eat();
    aliceDog.foul();
  }
}