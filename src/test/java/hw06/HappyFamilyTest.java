package hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyFamilyTest {
  private Human father, mother, child1, child2;
  private Pet pet1,pet2;
  private Family fm1,fm2;

  @Test
  void testDeleteChild1(){
    //check if the child is actually being removed from the `children` array
    father = new Human();
    mother = new Human();
    fm1 = new Family(father, mother);
    child1 = new Human("Child1","Childs1",fm1,100);
    child2 = new Human("Child2","Childs2",fm1,200);
    fm1.addChild(child1);
    fm1.addChild(child2);
    boolean expected = true;
    boolean actual = fm1.deleteChild(child1);
    assertEquals(expected,actual);
  }
}