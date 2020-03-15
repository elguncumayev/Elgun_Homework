package hw06;

public class Main {
  public static void main(String[] args) {
//    for (int i = 0; i < 5000000; i++) {
//      Human human = new Human();
//    }
    String[][] elgunschedule = new String[][]{{DayOfWeek.MONDAY.name(), "go to course, write clean code"},
            {DayOfWeek.FRIDAY.name(), "rest"}};
    Human mother = new Human();
    Human father = new Human();
    Family jumayevs = new Family(father, mother);
    Pet dog = new Pet();
    Human elgun = new Human("Elgun", "Jumayev", 1999, 88, elgunschedule, dog);
    System.out.println(jumayevs.countFamily());
    System.out.println(elgun);
  }
}
