package hw04;

import java.util.Arrays;

public class Pet {public Pet(){

}
  public Pet(String species,String nickname){
    this.species = species;
    this.nickname = nickname;
  }
  public Pet(String species,String nickname,int age,int trickLevel,String[] habits){
    this.species = species;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }
  String species;
  String nickname;
  int age;
  int trickLevel;
  String[] habits;

  public void eat(){
    System.out.println("I am eating.");
  }
  public void respond(){
    System.out.printf("Hello, owner. I am %s. I miss you!\n",this.nickname);
  }
  public void foul(){
    System.out.println("I need to cover it up.");
  }
  public String toString(){
    return this.species+"{nickname='"+this.nickname+"', age="+this.age+", trickLevel="+this.trickLevel+
            ", habits="+ Arrays.toString(this.habits) +"}";
  }
}
