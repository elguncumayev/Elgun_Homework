package hw07;

public class DomesticCat extends Pet {
  public DomesticCat() {
    super();
    this.species = Species.DOMESTICCAT;
  }
  public DomesticCat( String nickname) {
    super(nickname);
    this.species = Species.DOMESTICCAT;
  }

  public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
    super(nickname,age,trickLevel,habits);
    this.species = Species.DOMESTICCAT;
  }
  @Override
  void respond() {
    System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
  }
  public void foul() {
    System.out.println("I need to cover it up.");
  }
}
