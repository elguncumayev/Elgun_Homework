package hw13.Services;

import hw13.Animal.Pet;
import hw13.dao.CollectionFamilyDao;
import hw13.Family.Family;
import hw13.dao.FamilyDao;
import hw13.People.Human;
import hw13.People.MaleName;
import hw13.People.Man;
import hw13.People.Woman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
  private FamilyDao<Family> dao = new CollectionFamilyDao();

  public List<Family> getAllFamilies() {
    return dao.getAllFamilies();
  }

  public void displayAllFamilies() {
    dao.getAllFamilies().stream().map(Family::prettyFormat).forEach(System.out::println);
  }

  public void getFamiliesBiggerThan(int number) {
    System.out.println(getAllFamilies().stream().filter(x -> x.countFamily() > number).map(Family::prettyFormat).collect(Collectors.toList()));
  }

  public void getFamiliesLessThan(int number) {
    System.out.println(getAllFamilies().stream().filter(x -> x.countFamily() < number).map(Family::prettyFormat).collect(Collectors.toList()));
  }

  public void getFamiliesWithMembers(int number) {
    System.out.println(getAllFamilies().stream().filter(x -> x.countFamily() == number).map(Family::prettyFormat).collect(Collectors.toList()));
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
      child = new Man(MaleName.randomName().name(), family.getFather().getSurname(), LocalDate.now().toEpochDay()*86400000);
    } else {
      child = new Woman(MaleName.randomName().name(), family.getFather().getSurname(), LocalDate.now().toEpochDay()*86400000);
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
    dao.getAllFamilies().forEach(f -> {
      List<Human> children = f.getChildren();
      children.forEach(h -> {
        if (h.getAge()>age) f.deleteChild(h);
      });
      dao.saveFamily(f);
    });
  }

  public int count() {
    return getAllFamilies().size();
  }

  public Family getFamilyById(int index) {
    return dao.getFamilyByIndex(index);
  }

  public List<Pet> getPets(int index) {
    return new ArrayList<>(getFamilyById(index).getPets());
  }

  public void addPet(int index, Pet pet) {
    HashSet<Pet> pets = new HashSet<>(getFamilyById(index).getPets());
    pets.add(pet);
    Family familyById = getFamilyById(index);
    familyById.setPets(pets);
    dao.saveFamily(familyById);
  }

  public void loadData() {
    dao.loadData();
  }
  public void saveData(){
    dao.saveToLocal();
  }
}
