package hw12.Animal;

import java.util.HashSet;

public class Dog extends Pet {
  public Dog() {
    super();
    this.species = Species.DOG;
  }
  public Dog(String nickname) {
    super(nickname);
    this.species = Species.DOG;
  }

  public Dog(String nickname, int age, int trickLevel, HashSet<String> habits) {
    super(nickname,age,trickLevel,habits);
    this.species = Species.DOG;
  }

  @Override
  protected void respond() {
    System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
  }
  public void foul() {
    System.out.println("I need to cover it up.");
  }
}
