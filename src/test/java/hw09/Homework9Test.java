package hw09;

import hw09.Animal.*;
import hw09.Family.Family;
import hw09.Family.FamilyController;
import hw09.Family.FamilyService;
import hw09.People.Human;
import hw09.People.Man;
import hw09.People.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Homework9Test {
  FamilyService fs;
  private Human father, mother, child1, child2;
  private Pet pet1, pet2, pet3, pet4;
  private Family fm1;
  private HashMap<DayOfWeek, ArrayList<String>> schedule1, schedule2, schedule3, schedule4;
  @BeforeEach
  void set(){
    fs = new FamilyService();
    pet1 = new Dog("dognickname", 3, 45, new HashSet<>(Arrays.asList("doghabit1", "doghabit2")));
    pet2 = new DomesticCat("catnickname", 4, 47, new HashSet<>(Arrays.asList("cathabit1", "cathabit2")));
    pet3 = new RoboCat("robocatnickname", 1, 65, new HashSet<>(Arrays.asList("robocathabit1", "robocathabit2")));
    pet4 = new Fish("fishnickname", 2, 43, new HashSet<>(Arrays.asList("fishhabit1", "fishhabit2")));
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
    fm1 = fs.createNewFamily(father,mother);
  }
  @Test
  void test1(){
    int expected = 1;
    int actual = fs.count();
    assertEquals(expected,actual);
  }
  @Test
  void test2(){
    fs.deleteFamilyByIndex(0);
    int expected = 0;
    int actual = fs.count();
    assertEquals(expected,actual);
  }
  @Test
  void test3(){
    fs.bornChild(fm1,"masculine");
    int expected = 3;
    int actual = fs.getFamilyById(0).countFamily();
    assertEquals(expected,actual);
  }
  @Test
  void test4(){
    fs.adoptChild(fm1,child1);
    int expected = 3;
    int actual = fs.getFamilyById(0).countFamily();;
    assertEquals(expected,actual);
  }
  @Test
  void test5(){
    fs.bornChild(fm1,"masculine");
    fs.adoptChild(fm1,child1);
    long expected = 1;
    long actual = fs.countFamiliesWithMemberNumber(4);
    assertEquals(expected,actual);
  }

}