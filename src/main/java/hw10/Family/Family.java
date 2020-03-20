package hw10.Family;

import hw10.Animal.Pet;
import hw10.People.Human;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Family {
  private Human mother;
  private Human father;
  private List<Human> children = new ArrayList<>();
  private Set<Pet> pet = new HashSet<>();

  public Family(Human father, Human mother) {
    this.father = father;
    this.mother = mother;
  }

  public Human getMother() {
    return mother;
  }

  public void setMother(Human mother) {
    this.mother = mother;
  }

  public Human getFather() {
    return father;
  }

  public void setFather(Human father) {
    this.father = father;
  }

  public Set<Pet> getPet() {
    return pet;
  }

  public void setPet(Set<Pet> pet) {
    this.pet = pet;
  }

  public List<Human> getChildren() {
    return this.children;
  }

  //changing addChild method type void to boolean to fulfill the task
  public boolean addChild(Human child) {
    if (child.getName() == null || child.getSurname() == null) {
      return false;
    } else {
      this.children.add(child);
      child.setFamily(this);
      return true;
    }
  }

  public boolean deleteChild(Human child) {
    if(this.children.isEmpty()) return false;
    if(!this.children.contains(child)) return false;
    this.children.remove(child);
    child.deleteFromFamily();
    return true;
  }

  public boolean deleteChild(int index) {
    if(index<0 || index>=this.children.size()) return false;
    this.children.get(index).deleteFromFamily();
    this.children.remove(index);
    return true;
  }

  public int countFamily() {
    return 2 + this.getChildren().size();
  }

  @Override
  public String toString() {
    return String.format("Father{%s}\nMother{%s}\nChildren{%s}\nPet{%s}",
            this.father.toString(), this.mother.toString(),this.children, this.pet.toString());
  }

  @Override
  public int hashCode() {
    int result = 19;
    result = result * 13 + this.father.hashCode();
    result = result * 13 + this.mother.hashCode();
    result = result * 13 + this.children.hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Family)) return false;
    Family that = (Family) obj;
    return this.mother.equals(that.mother) &&
            this.father.equals(that.father);
  }

  @Override
  protected void finalize() {
    System.out.printf("Object is deleted: %s\n", this.getClass());
  }
}
