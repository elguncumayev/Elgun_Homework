package hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework6Test {
  private Human father, mother, child1, child2;
  private Pet pet1, pet2, pet3, pet4;
  private Family fm1;

  @BeforeEach
  void set() {
    pet1 = new Pet(Species.DOG, "dognickname", 3, 45, new String[]{"doghabit1", "doghabit2"});
    pet2 = new Pet(Species.CAT, "catnickname", 4, 47, new String[]{"cathabit1", "cathabit2"});
    pet3 = new Pet(Species.BIRD, "birdnickname", 1, 49, new String[]{"birdhabit1", "birdhabit2"});
    pet4 = new Pet(Species.FISH, "fishnickname", 2, 43, new String[]{"fishhabit1", "fishhabit2"});
    fm1 = new Family(father, mother);
    father = new Human("Father", "Surname", 100, 93,
            new String[][]{{DayOfWeek.MONDAY.name(), "fatheractivity1"}, {DayOfWeek.TUESDAY.name(), "fatheractivity2"}}, pet1);
    mother = new Human("Mother", "Surname", 101, 92,
            new String[][]{{DayOfWeek.WEDNESDAY.name(), "motheractivity1"}, {DayOfWeek.THURSDAY.name(), "motheractivity2"}}, pet2);
    child1 = new Human("Child1", "Surname", 110, 89,
            new String[][]{{DayOfWeek.FRIDAY.name(), "child1activity1"}, {DayOfWeek.SATURDAY.name(), "child1activity2"}}, pet3);
    child2 = new Human("Child2", "Surname", 112, 88,
            new String[][]{{DayOfWeek.SUNDAY.name(), "child2activity1"}, {DayOfWeek.MONDAY.name(), "child2activity2"}}, pet4);
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
  void testCountFamil(){
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