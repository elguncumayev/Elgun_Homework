package hw07;

import java.util.Arrays;

public class Human {
  protected String name;
  protected String surname;
  protected int dateOfBirth;
  protected int iqLevel;
  protected String[][] schedule;
  protected Family family;

  public Human() {
  }

  public Human(String name, String surname, int dateOfBirth) {
    this.setName(name);
    this.setSurname(surname);
    this.setDateOfBirth(dateOfBirth);
  }

  public Human(String name, String surname,int dateOfBirth, int iqLevel, String[][] schedule) {
    this.name = name;
    this.surname = surname;
    this.dateOfBirth = dateOfBirth;
    this.iqLevel = iqLevel;
    this.schedule = schedule;

  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public Family getFamily() {
    return family;
  }
  public void setFamily(Family family) {
    this.family = family;
  }
  public int getDateOfBirth() {
    return dateOfBirth;
  }
  public void setDateOfBirth(int dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public int getIqLevel() {
    return iqLevel;
  }
  public void setIqLevel(int iqLevel) {
    this.iqLevel = iqLevel;
  }
  public String[][] getSchedule() {
    return schedule;
  }
  public void setSchedule(String[][] schedule) {
    this.schedule = schedule;
  }


  public void deleteFromFamily(){
    this.family = null;
  }

  public void greetPet() {
    System.out.printf("Hello, %s.\n", this.getFamily().getPet().getNickname());
  }

  public void describePet() {
    System.out.printf("We have a %s, he is %d years old, he is %s.\n"
            , this.getFamily().getPet().getNickname(), this.getFamily().getPet().getAge(), this.getFamily().getPet().getTrickLevel() > 50 ? "very sly" : "almost not sly");
  }

  public String toString() {
    return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule= %s",
            this.getName(), this.getSurname(),this.getDateOfBirth(), this.getIqLevel(), Arrays.deepToString(this.schedule));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result*23 + this.name.hashCode();
    result = result*23 + this.surname.hashCode();
    result = result*23 + this.dateOfBirth;
    result = result*23 + this.iqLevel;
    return result;
  }

  @Override
  public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof Human)) {
      return false;
    }
    Human that = (Human) o;
    return that.name.equals(this.name) &&
            that.surname.equals(this.surname) &&
            that.dateOfBirth == this.dateOfBirth &&
            that.family.equals(this.family) &&
            that.iqLevel == this.iqLevel;
  }
  @Override
  protected void finalize(){
    System.out.printf("Object is deleted: %s\n",this.getClass());
  }
}
