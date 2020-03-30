package hw12;

import hw12.Animal.Dog;
import hw12.Animal.Pet;
import hw12.Family.Family;
import hw12.Services.FamilyService;
import hw12.People.*;

import java.util.HashSet;

public class TestingMain {
  public static void main(String[] args) {
    FamilyService fS = new FamilyService();
    Human simpsonsFather = new Human(MaleName.randomName().name(), "Simpsons", "01/01/1993",90);
    Human simpsonsMother = new Human(FemaleName.randomName().name(), "Simpsons", "01/01/1994",89);
    Family family = new Family(simpsonsFather, simpsonsMother);
    fS.bornChild(family,"masculine");
    Human child2 = new Woman("Child2", "Carlson", "01/01/2018",87);
    fS.adoptChild(family,child2);
    Pet jack = new Dog("Jack");
    HashSet<Pet> pets = new HashSet<>();
    pets.add(jack);
    family.setPets(pets);
    fS.displayAllFamilies();
  }
}
