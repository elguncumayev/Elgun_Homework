package hw06;

public class Main {
  public static void main(String[] args) {
//    for (int i = 0; i < 5000000; i++) {
//      Human human = new Human();
//    }
    String[][] elgunschedule = new String[][]{{DayOfWeek.name("MonDAy").toString(), "go to course, write clean code"},
            {DayOfWeek.name("FrIdAy").toString(), "rest"}};
    Human mother = new Human();
    Human father = new Human();
    Family jumayevs = new Family(father, mother);
    Pet dog = new Pet();
    Human elgun = new Human("Elgun", "Jumayev", jumayevs, 1999, 88, elgunschedule, dog);
    System.out.println(jumayevs.countFamily());
    System.out.println(elgun);
  }
}
