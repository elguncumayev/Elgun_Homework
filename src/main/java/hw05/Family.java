package hw05;

import java.util.ArrayList;
import java.util.Arrays;

public class Family {
  private Human mother;
  private Human father;
  private Human[] children;
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

  public Human[] getChildren() {
    return this.children;
  }

  public void addChild(Human child) {
    int childrenArraySize = this.children.length;
    Human[] newChildren = new Human[childrenArraySize + 1];
    System.arraycopy(this.children, 0, newChildren, 0, newChildren.length - 1);
    newChildren[childrenArraySize] = child;
    this.children = newChildren;
    child.setFamily(this);
  }

  public void deleteChild(Human child) {
    int childrenArraySize = this.children.length;
    Human[] newChildren = new Human[childrenArraySize - 1];
    int indexForNew = 0;
    for (Human child1 : this.children){
      if(!(child1 == child)){
        newChildren[indexForNew] = child;
        indexForNew++;
      }
    }
    this.children = newChildren;
    child.deleteFromFamily();
  }

  public Family(Human father, Human mother) {
    this.father = father;
    this.mother = mother;
  }

  public int countFamily() {
    return 2 + this.getChildren().length;
  }

  @Override
  public String toString() {
    return String.format("Father{%s}\nMother{%s}\nChildren{%s}\nPet{%s}",
            this.father.toString(), this.mother.toString(), Arrays.toString(this.children), this.pet.toString());
  }

  @Override
  public int hashCode() {
    int result = 19;
    result = result * 13 + this.father.hashCode();
    result = result * 13 + this.mother.hashCode();
    result = result * 13 + Arrays.hashCode(this.children);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Family)) return false;
    Family that = (Family) obj;
    return this.mother.equals(that.mother) &&
            this.father.equals(that.father) &&
            Arrays.equals(this.children, that.children);
  }
}
