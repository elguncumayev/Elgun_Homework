package hw04;

import java.util.Arrays;

public class Human {
    public Human(){
    }
    public Human(String name,String surname,int dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    public Human(String name,String surname,int dateOfBirth,Human father,Human mother){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.father = father;
        this.mother = mother;
    }
    public Human(String name,String surname,int dateOfBirth,int iqLevel,Pet pet,Human father,Human mother,String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.iqLevel = iqLevel;
        this.pet = pet;
        this.father = father;
        this.mother = mother;
        this.schedule = schedule;
    }
    String name = "No data";
    String surname;
    int dateOfBirth;
    int iqLevel;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public void greetPet(){
        System.out.printf("Hello, %s.\n",this.pet.nickname);
    }
    public void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s.\n"
                ,this.pet.species,this.pet.age,this.pet.trickLevel>50 ? "very sly" : "almost not sly");
    }
    public String toString(){
        return "Human{name='"+this.name+"', surname='"+this.surname+"', year="+this.dateOfBirth+", iq="+this.iqLevel+
              ", mother="+this.mother.name+" "+this.mother.surname+", father="+this.father.name+" "+this.father.surname+
              ", pet="+this.pet.species+"{nickname='"+this.pet.nickname+"', age="+this.pet.age+
              ", trickLevel="+this.pet.trickLevel+", habits="+ Arrays.toString(this.pet.habits) +"}}";
    }
}
