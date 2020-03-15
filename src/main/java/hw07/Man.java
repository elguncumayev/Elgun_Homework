package hw07;

public final class Man extends Human {
  public Man() {
    super();
  }

  public Man(String name, String surname, int dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Man(String name, String surname, int dateOfBirth, int iqLevel, String[][] schedule, Pet pet) {
    super(name,surname,dateOfBirth,iqLevel,schedule,pet);
  }

  public void repairCar(){
    System.out.println("There was a little problem. I got it.");
  }

  /*@Override
  void greetPet() {
    System.out.printf("Hello, %s.\n. What did you do today?", this.pet.getNickname());
  }*/
}