package hw07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework7Test {
  private Human father, mother, child1, child2;
  private Pet pet1, pet2, pet3, pet4;
  private Family fm1;

  @BeforeEach
  void set() {
    pet1 = new Dog("dognickname", 3, 45, new String[]{"doghabit1", "doghabit2"});
    pet2 = new DomesticCat( "catnickname", 4, 47, new String[]{"cathabit1", "cathabit2"});
    pet3 = new RoboCat("robocatnickname", 1, 65, new String[]{"robocathabit1", "robocathabit2"});
    pet4 = new Fish("fishnickname", 2, 43, new String[]{"fishhabit1", "fishhabit2"});
    fm1 = new Family(father, mother);
//    father = new Man("Father", "Surname", 100, 93,
//            new String[][]{{DayOfWeek.name(DayOfWeek.MONDAY), "fatheractivity1"}, {DayOfWeek.name(DayOfWeek.TUESDAY), "fatheractivity2"}}, pet1);
//    mother = new Woman("Mother", "Surname", 101, 92,
//            new String[][]{{DayOfWeek.name(DayOfWeek.WEDNESDAY), "motheractivity1"}, {DayOfWeek.name(DayOfWeek.THURSDAY), "motheractivity2"}}, pet2);
//    child1 = new Man("Child1", "Surname", 110, 89,
//            new String[][]{{DayOfWeek.name(DayOfWeek.FRIDAY), "child1activity1"}, {DayOfWeek.name(DayOfWeek.SATURDAY), "child1activity2"}}, pet3);
//    child2 = new Woman("Child2", "Surname", 112, 88,
//            new String[][]{{DayOfWeek.name(DayOfWeek.SUNDAY), "child2activity1"}, {DayOfWeek.name(DayOfWeek.MONDAY), "child2activity2"}}, pet4);
  }

  @Test
  void testDeleteChild1() {
    //check if the child is actually being removed from the `children` array
    fm1.addChild(child1);
    fm1.addChild(child2);
    boolean expected = true;
    boolean actual = fm1.deleteChild(child1);
    assertEquals(expected, actual);
  }
  @Test
  void testDeleteChild2() {
    //check if the child is actually being removed from the `children` array
    fm1.addChild(child1);
    boolean expected = false;
    boolean actual = fm1.deleteChild(child2);
    assertEquals(expected, actual);
  }
  @Test
  void testDeleteChild3() {
    //check if the child is actually being removed from the `children` array
    fm1.addChild(child1);
    fm1.addChild(child2);
    boolean expected = true;
    boolean actual = fm1.deleteChild(1);
    assertEquals(expected, actual);
  }
  @Test
  void testDeleteChild4() {
    //check if the child is actually being removed from the `children` array
    fm1.addChild(child1);
    fm1.addChild(child2);
    boolean expected = false;
    boolean actual = fm1.deleteChild(2);
    assertEquals(expected, actual);
  }
  @Test
  void testAddChild(){
    fm1.addChild(child1);
    int expected = 1;
    int actual = fm1.getChildren().length;
    assertEquals(expected,actual);
  }
  @Test
  void testCountFamily(){
    fm1.addChild(child1);
    fm1.addChild(child2);
    int expected = 4;
    int actual = fm1.countFamily();
    assertEquals(expected,actual);
  }


  @Test
  void testToStringHuman() {
    String expected = "Human{name='Mother', surname='Surname', year=101, iq=92, schedule= [[WEDNESDAY, motheractivity1], [THURSDAY, motheractivity2]]";
    String actual = mother.toString();
    assertEquals(expected,actual);
  }
  @Test
  void  testToStringPet(){
    String expected = "DOG{nickname='dognickname', age=3, trickLevel=45, habits=[doghabit1, doghabit2]}";
    String actual = pet1.toString();
    assertEquals(expected,actual);
  }
}