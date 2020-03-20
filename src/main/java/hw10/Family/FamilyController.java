package hw10.Family;

import hw10.Animal.Pet;
import hw10.People.Human;

public class FamilyController {
  private FamilyService service = new FamilyService();

  public void displayAllFamilies(){
    service.displayAllFamilies();
  }
  public void getFamiliesBiggerThan(int number){
    service.getFamiliesBiggerThan(number);
  }
  public void getFamiliesLessThan(int number){
    service.getFamiliesLessThan(number);
  }
  public long countFamiliesWithMemberNumber(int number){
    return service.countFamiliesWithMemberNumber(number);
  }
  public Family createNewFamily(Human father, Human mother){
    return service.createNewFamily(father,mother);
  }
  public boolean deleteFamilyByIndex(int index){
    return service.deleteFamilyByIndex(index);
  }
  public Family bornChild(Family family, String gender){
    return service.bornChild(family,gender);
  }
  public Family adoptChild(Family family, Human child){
    return service.adoptChild(family,child);
  }
  public void deleteAllChildrenOlderThen(int age){
    service.deleteAllChildrenOlderThen(age);
  }
  public int count(){
    return service.count();
  }

  public Family getFamilyById(int index){
    return service.getFamilyById(index);
  }
  public String getPets(int index){
    return service.getPets(index).toString();
  }
  public void addPet(int index, Pet pet){
    service.addPet(index,pet);
  }
}
