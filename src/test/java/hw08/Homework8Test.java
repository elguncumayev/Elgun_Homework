package hw08;

import hw08.Animal.*;
import hw08.People.Family;
import hw08.People.Human;
import hw08.People.Man;
import hw08.People.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework8Test {
  private Human father, mother, child1, child2;
  private Pet pet1, pet2, pet3, pet4;
  private Family fm1;
  private HashMap<DayOfWeek, ArrayList<String>> schedule1, schedule2, schedule3, schedule4;

  @BeforeEach
  void set() {
    pet1 = new Dog("dognickname", 3, 45, new HashSet<>(Arrays.asList("doghabit1", "doghabit2")));
    pet2 = new DomesticCat("catnickname", 4, 47, new HashSet<>(Arrays.asList("cathabit1", "cathabit2")));
    pet3 = new RoboCat("robocatnickname", 1, 65, new HashSet<>(Arrays.asList("robocathabit1", "robocathabit2")));
    pet4 = new Fish("fishnickname", 2, 43, new HashSet<>(Arrays.asList("fishhabit1", "fishhabit2")));
    fm1 = new Family(father, mother);
    schedule1 = new HashMap<>();
    schedule2 = new HashMap<>();
    schedule3 = new HashMap<>();
    schedule4 = new HashMap<>();
    schedule1.put(DayOfWeek.MONDAY, new ArrayList<>(Arrays.asList("fatheractivity1", "fatheractivity2")));
    schedule1.put(DayOfWeek.TUESDAY, new ArrayList<>(Arrays.asList("fatheractivity3", "fatheractivity4")));
    schedule2.put(DayOfWeek.WEDNESDAY, new ArrayList<>(Arrays.asList("motheractivity1", "motheractivity2")));
    schedule2.put(DayOfWeek.THURSDAY, new ArrayList<>(Arrays.asList("motheractivity3", "motheractivity4")));
    schedule3.put(DayOfWeek.FRIDAY, new ArrayList<>(Arrays.asList("child1activity1", "child1activity2")));
    schedule3.put(DayOfWeek.SATURDAY, new ArrayList<>(Arrays.asList("child1activity3", "child1activity4")));
    schedule4.put(DayOfWeek.SUNDAY, new ArrayList<>(Arrays.asList("child2activity1", "child2activity2")));
    schedule4.put(DayOfWeek.MONDAY, new ArrayList<>(Arrays.asList("child2activity3", "child2activity4")));
    father = new Man("Father", "Surname", 100, 93, schedule1);
    mother = new Woman("Mother", "Surname", 101, 92, schedule2);
    child1 = new Man("Child1", "Surname", 110, 89, schedule3);
    child2 = new Woman("Child2", "Surname", 112, 88, schedule4);
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
  void testAddChild() {
    fm1.addChild(child1);
    int expected = 1;
    int actual = fm1.getChildren().size();
    assertEquals(expected, actual);
  }

  @Test
  void testCountFamily() {
    fm1.addChild(child1);
    fm1.addChild(child2);
    int expected = 4;
    int actual = fm1.countFamily();
    assertEquals(expected, actual);
  }


  @Test
  void testToStringHuman() {
    String expected = "Human{name='Mother', surname='Surname', year=101, iq=92, schedule= {WEDNESDAY=[motheractivity1, " +
            "motheractivity2], THURSDAY=[motheractivity3, motheractivity4]}";
    String actual = mother.toString();
    assertEquals(expected, actual);
  }

  @Test
  void testToStringPet() {
    String expected = "DOG{nickname='dognickname', age=3, trickLevel=45, habits=[doghabit1, doghabit2]}";
    String actual = pet1.toString();
    assertEquals(expected, actual);
  }
}