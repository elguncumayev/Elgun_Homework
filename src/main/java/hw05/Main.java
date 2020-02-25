package hw05;

public class Main {
  public static void main(String[] args) {
    Human johnSmith = new Human("John", "Smith", 1973);

    String[] aliceDogHabits = {"sleep", "play"};
    Pet aliceDog = new Pet("Dog", "Marshmallow", 3, 68, aliceDogHabits);
    Human aliceSmith = new Human("Alice", "Smith", 1975);

    Family smiths = new Family(johnSmith, aliceSmith);

    Human oliviaSmith = new Human("Olivia", "Smith", 1996);

    Pet davidDog = new Pet("Dog", "Rocky", 4, 48, new String[]{"run", "play"});
    String[][] davidSchedule = {{"Sunday", "do homework"}, {"Monday", "go to course"}};
    Human davidSmith = new Human("David", "Smith", smiths, 1998, 88, davidSchedule, davidDog);

    System.out.println(oliviaSmith.getFamily());
    smiths.addChild(oliviaSmith);
    smiths.addChild(davidSmith);
    System.out.println(smiths.countFamily());

    smiths.deleteChild(oliviaSmith);
    System.out.println(smiths.countFamily());

    System.out.println(oliviaSmith.getFamily());
    System.out.println(davidSmith.toString());
    davidSmith.greetPet();
    davidSmith.describePet();
    System.out.println(aliceDog.toString());
    aliceDog.respond();
    aliceDog.eat();
    aliceDog.foul();
  }
}