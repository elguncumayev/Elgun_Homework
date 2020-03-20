package hw10.Animal;

import java.util.HashSet;

public abstract class Pet {
  public Species species = Species.UNKNOWN;
  protected String nickname;
  protected int age;
  protected int trickLevel;
  protected HashSet<String> habits = new HashSet<>();

  public Pet() {
  }

  public Pet(String nickname) {
    this.nickname = nickname;
  }

  public Pet(String nickname, int age, int trickLevel, HashSet<String> habits) {
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getTrickLevel() {
    return trickLevel;
  }

  public void setTrickLevel(int trickLevel) {
    this.trickLevel = trickLevel;
  }

  public HashSet<String> getHabits() {
    return habits;
  }

  public void setHabits(HashSet<String> habits) {
    this.habits = habits;
  }

  public void eat() {
    System.out.println("I am eating.");
  }

  protected abstract void respond();
  protected abstract void foul();
  public String toString() {
    return this.species + "{nickname='" + this.nickname + "', age=" + this.age + ", trickLevel=" + this.trickLevel +
            ", habits=" + this.habits + "}";
  }

  @Override
  public int hashCode() {
    int result = 19;
    result = result * 31 + this.nickname.hashCode();
    result = result * 31 + this.age;
    result = result * 31 + this.trickLevel;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Pet)) return false;
    Pet that = (Pet) obj;
    return this.nickname.equals(that.nickname) &&
            this.age == that.age &&
            this.trickLevel == that.trickLevel;
  }

  @Override
  protected void finalize() {
    System.out.printf("Object is deleted: %s\n", this.getClass());
  }
}
