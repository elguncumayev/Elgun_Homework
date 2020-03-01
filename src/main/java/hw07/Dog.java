package hw07;

public class Dog extends Pet {
  public Dog() {
    super();
    this.species = Species.DOG;
  }
  public Dog(String nickname) {
    super(nickname);
    this.species = Species.DOG;
  }

  public Dog( String nickname, int age, int trickLevel, String[] habits) {
    super(nickname,age,trickLevel,habits);
    this.species = Species.DOG;
  }

  @Override
  void respond() {
    System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
  }
  public void foul() {
    System.out.println("I need to cover it up.");
  }
}
