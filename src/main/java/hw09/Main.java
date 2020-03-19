package hw09;

import hw09.Animal.*;
import hw09.Family.Family;
import hw09.Family.FamilyController;
import hw09.People.Human;
import hw09.People.Man;
import hw09.People.Woman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    FamilyController fc = new FamilyController();

    Human father, mother, child1, child2;
    Pet pet1, pet2, pet3, pet4;
    Family fm1;
    HashMap<DayOfWeek, ArrayList<String>> schedule1, schedule2, schedule3, schedule4;


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


    Family family1 = fc.createNewFamily(father, mother);
    Family newFamily = fc.bornChild(family1, "masculine");
    Family newFamily2 = fc.adoptChild(newFamily, child1);
    fc.addPet(0,pet1);
    long number = fc.countFamiliesWithMemberNumber(4);
    System.out.printf("Number of families with 4 numbers: %d\n\n",number);
    fc.deleteAllChildrenOlderThen(100);
    System.out.print("Bigger than 2:  ");
    fc.getFamiliesBiggerThan(2);
    System.out.println();
    System.out.print("Less than 5:  ");
    fc.getFamiliesLessThan(5);
    System.out.println();
    String pets = fc.getPets(0);
    System.out.print("Pets:  ");
    System.out.println(pets);
    System.out.println();
    int count = fc.count();
    System.out.print("Count:  ");
    System.out.println(count);
    System.out.println();
    Family familyById = fc.getFamilyById(0);
    System.out.print("Family by Id 0:  ");
    System.out.println(familyById);
    System.out.println();
    fc.displayAllFamilies();
    fc.deleteFamilyByIndex(0);
    fc.displayAllFamilies();

  }
}
