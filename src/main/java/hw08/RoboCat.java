package hw08;

import java.util.HashSet;

public class RoboCat extends Pet {
  public RoboCat() {
    super();
    this.species = Species.ROBOCAT;
  }
  public RoboCat(String nickname) {
    super(nickname);
    this.species = Species.ROBOCAT;
  }

  public RoboCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
    super(nickname, age, trickLevel, habits);
    this.species = Species.ROBOCAT;
  }

  @Override
  void respond() {
    System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
  }
}
