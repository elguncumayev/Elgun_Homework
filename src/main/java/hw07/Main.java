package hw07;

public class Main {
  public static void main(String[] args) {
    Pet dogg = new Pet() {
      @Override
      void respond() {
        System.out.println("WHat HAppEnS?");
      }
    };
    System.out.println(dogg.species);
    String[][] elgunschedule = new String[][]{{DayOfWeek.name(DayOfWeek.MONDAY), "go to course, write clean code"},
            {DayOfWeek.name(DayOfWeek.FRIDAY), "rest"}};
    Human mother = new Woman();
    Human father = new Man();
    Family jumayevs = new Family(father, mother);
    Pet dog = new Dog("dognickname", 3, 45, new String[]{"doghabit1", "doghabit2"});
    System.out.println(dog.species);
    Human elgun = new Man("Elgun", "Jumayev", 1999, 88, elgunschedule, dog);
    System.out.println(jumayevs.countFamily());
    System.out.println(elgun);
  }
}