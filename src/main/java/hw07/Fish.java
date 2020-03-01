package hw07;

public class Fish extends Pet {

  public Fish() {
    super();
    this.species = Species.FISH;
  }

  public Fish(String nickname) {
    super(nickname);
    this.species = Species.FISH;
  }

  public Fish( String nickname, int age, int trickLevel, String[] habits) {
    super(nickname, age, trickLevel, habits);
    this.species = Species.FISH;
  }

  @Override
  void respond() {
    System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
  }
}
