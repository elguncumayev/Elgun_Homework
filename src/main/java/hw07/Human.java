package hw07;

import java.util.Arrays;

public abstract class Human {
  protected String name;
  protected String surname;
  protected int dateOfBirth;
  protected int iqLevel;
  protected String[][] schedule;
  protected Family family;
  protected Pet pet;

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
  public Pet getPet() {
    return pet;
  }
  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public void deleteFromFamily(){
    this.family = null;
  }

  public Human() {
  }

  public Human(String name, String surname, int dateOfBirth) {
    this.setName(name);
    this.setSurname(surname);
    this.setDateOfBirth(dateOfBirth);
  }

  public Human(String name, String surname,int dateOfBirth, int iqLevel, String[][] schedule,Pet pet) {
    this.name = name;
    this.surname = surname;
    this.dateOfBirth = dateOfBirth;
    this.iqLevel = iqLevel;
    this.schedule = schedule;
    this.pet = pet;
  }

  abstract void greetPet();
  public void describePet(){
    System.out.printf("I have a %s, he is %d years old, he is %s.\n"
            , this.pet.getSpecies(), this.pet.getAge(), this.pet.getTrickLevel() >50 ? "very sly" : "almost not sly");
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
