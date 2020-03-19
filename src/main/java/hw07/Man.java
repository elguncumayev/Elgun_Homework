package hw07;

public final class Man extends Human {
  public Man() {
    super();
  }

  public Man(String name, String surname, int dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Man(String name, String surname, int dateOfBirth, int iqLevel, String[][] schedule) {
    super(name,surname,dateOfBirth,iqLevel,schedule);
  }

  public void repairCar(){
    System.out.println("There was a little problem. I got it.");
  }

}