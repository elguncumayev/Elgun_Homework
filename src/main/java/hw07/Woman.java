package hw07;

public final class Woman extends Human {
  public Woman() {
    super();
  }

  public Woman(String name, String surname, int dateOfBirth) {
    super(name,surname,dateOfBirth);
  }

  public Woman(String name, String surname, int dateOfBirth, int iqLevel, String[][] schedule) {
    super(name,surname,dateOfBirth,iqLevel,schedule);
  }

  public void makeUp(){
    System.out.println("A little makeup. Okay, now I look better.");
  }

}
