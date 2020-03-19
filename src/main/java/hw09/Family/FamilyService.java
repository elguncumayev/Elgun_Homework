package hw09.Family;

import hw09.Animal.Pet;
import hw09.People.Human;
import hw09.People.MaleName;
import hw09.People.Man;
import hw09.People.Woman;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {
  private FamilyDao<Family> dao = new CollectionFamilyDao();

  public List<Family> getAllFamilies() {
    return dao.getAllFamilies();
  }

  public void displayAllFamilies() {
    System.out.println(getAllFamilies());
  }

  public void getFamiliesBiggerThan(int number) {
    System.out.println(getAllFamilies().stream().filter(x -> x.countFamily() > number).collect(Collectors.toList()));
  }

  public void getFamiliesLessThan(int number) {
    System.out.println(getAllFamilies().stream().filter(x -> x.countFamily() < number).collect(Collectors.toList()));
  }

  public long countFamiliesWithMemberNumber(int number) {
    return getAllFamilies().stream().filter(x -> x.countFamily() == number).count();
  }

  public Family createNewFamily(Human father, Human mother) {
    Family family = new Family(father, mother);
    dao.saveFamily(family);
    return family;
  }

  public boolean deleteFamilyByIndex(int index) {
    return dao.deleteFamily(index);
  }

  public Family bornChild(Family family, String gender) {
    Human child;
    if (gender.toLowerCase().equals("masculine")) {
      child = new Man(MaleName.randomName().name(), family.getFather().getSurname(), LocalDateTime.now().getYear());
    } else {
      child = new Woman(MaleName.randomName().name(), family.getFather().getSurname(), LocalDateTime.now().getYear());
    }

    family.addChild(child);
    dao.saveFamily(family);
    return family;
  }

  public Family adoptChild(Family family, Human child) {
    family.addChild(child);
    dao.saveFamily(family);
    return family;
  }

  public void deleteAllChildrenOlderThen(int age) {
    List<Family> allFamilies = dao.getAllFamilies();
    for (Family f : allFamilies) {
      ArrayList<Human> children = new ArrayList<>(f.getChildren());
      for (Human c : children){
        if(c.getAge()>age) f.deleteChild(c);
      }
      dao.saveFamily(f);
    }
  }

  public int count() {
    return getAllFamilies().size();
  }

  public Family getFamilyById(int index) {
    return dao.getFamilyByIndex(index);
  }

  public List<Pet> getPets(int index) {
    return new ArrayList<>(getFamilyById(index).getPet());
  }

  public void addPet(int index, Pet pet) {
    HashSet<Pet> pets = new HashSet<>(getFamilyById(index).getPet());
    pets.add(pet);
    Family familyById = getFamilyById(index);
    familyById.setPet(pets);
    dao.saveFamily(familyById);
  }
}
