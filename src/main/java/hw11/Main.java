package hw11;

import hw11.People.Human;

public class Main {
  public static void main(String[] args) {
    Human human = new Human("Name", "Surname", "10/10/1965", 90);
    System.out.println(human.describeAge());
    System.out.println(human);
  }
}
