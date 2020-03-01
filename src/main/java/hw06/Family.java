package hw06;

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

  //changing addChild method type void to boolean to fulfill the task
  public boolean addChild(Human child) {
    if (child.getName() == null || child.getSurname() == null) {
      return false;
    } else {
      int childrenArraySize = this.children.length;
      Human[] newChildren = new Human[childrenArraySize + 1];
      System.arraycopy(this.children, 0, newChildren, 0, childrenArraySize);
      newChildren[childrenArraySize] = child;
      this.children = newChildren;
      child.setFamily(this);
      return true;
    }
  }

  public boolean deleteChild(Human child) {
    int childrenArraySize = this.children.length;
    if (childrenArraySize == 0) {
      return false;
    }
    boolean contain = false;
    for (Human ch : this.children) {
      if (ch.equals(child)) {
        contain = true;
        break;
      }
    }
    if (!contain) return false;
    Human[] newChildren = new Human[childrenArraySize - 1];
    int indexForNew = 0;
    for (Human child1 : this.children) {
      if (!(child1.equals(child))) {
        newChildren[indexForNew] = child;
        indexForNew++;
      }
    }

    this.children = newChildren;
    child.deleteFromFamily();
    return true;
  }

  public boolean deleteChild(int index) {
    int childrenArraySize = this.children.length;
    if (index >= childrenArraySize || index <= 0) {
      return false;
    }
    else {
      Human[] newChildren = new Human[childrenArraySize - 1];
      int indexForNew = 0;
      boolean contain = true;
      for (int i = 0; i < childrenArraySize; i++) {
        if (i != index) {
          newChildren[indexForNew] = this.children[i];
          indexForNew++;
        }
      }
      this.children[index].deleteFromFamily();
      this.children = newChildren;
      return true;
    }
  }

  public Family(Human father, Human mother) {
    this.father = father;
    this.mother = mother;
    children = new Human[0];
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

  @Override
  protected void finalize() {
    System.out.printf("Object is deleted: %s\n", this.getClass());
  }
}
