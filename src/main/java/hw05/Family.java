package hw05;

import java.util.ArrayList;

public class Family {
  private Human mother;
  private Human father;
  private ArrayList<Human> children = new ArrayList<Human>();
  private Pet pet;

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

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public ArrayList<Human> getChildren() {
    return this.children;
  }

  public void addChild(Human child) {
    this.children.add(child);
    child.setFamily(this);
  }
  public void deleteChild(Human child){
    this.children.remove(child);
    child.deleteFromFamily();
  }
  public Family(Human father, Human mother) {
    this.father = father;
    this.mother = mother;
  }
  public int countFamily(){
    return 2+this.getChildren().size();
  }

  @Override
  public String toString() {
    return String.format("Father{%s}\nMother{%s}\nChildren{%s}\nPet{%s}",
            this.father.toString(),this.mother.toString(),this.children.toString(),this.pet.toString());
  }

  @Override
  public int hashCode() {
    int result = 19;
    result = result*13 + this.father.hashCode();
    result = result*13 + this.mother.hashCode();
    result = result*13 + this.children.hashCode();
    return  result;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == this) return  true;
    if(!(obj instanceof Family)) return false;
    Family that = (Family) obj;
    return this.mother.equals(that.mother) &&
            this.father.equals(that.father) &&
            this.children.equals(that.children);
  }
}
