package hw12.Controller;

import hw12.Animal.Pet;
import hw12.Family.Family;
import hw12.People.*;
import hw12.Services.FamilyService;

import java.util.Scanner;

public class FamilyController {
  private static int randID = 1;
  private FamilyService service = new FamilyService();
  private Scanner scan = new Scanner(System.in);

  public void displayAllFamilies() {
    service.displayAllFamilies();
  }

  public void getFamiliesBiggerThan(int number) {
    service.getFamiliesBiggerThan(number);
  }

  public void getFamiliesLessThan(int number) {
    service.getFamiliesLessThan(number);
  }

  public void getFamiliesWithMembers(int number) {
    service.getFamiliesWithMembers(number);
  }

  public long countFamiliesWithMemberNumber(int number) {
    return service.countFamiliesWithMemberNumber(number);
  }

  public Family createNewFamily(Human father, Human mother) {
    return service.createNewFamily(father, mother);
  }

  public boolean deleteFamilyByIndex(int index) {
    return service.deleteFamilyByIndex(index);
  }

  public Family bornChild(Family family, String gender) {
    return service.bornChild(family, gender);
  }

  public Family adoptChild(Family family, Human child) {
    return service.adoptChild(family, child);
  }

  public void deleteAllChildrenOlderThen(int age) {
    service.deleteAllChildrenOlderThen(age);
  }

  public int count() {
    return service.count();
  }

  public String getFamilyById(int index) {
    return service.getFamilyById(index).prettyFormat();
  }

  public String getPets(int index) {
    return service.getPets(index).toString();
  }

  public void addPet(int index, Pet pet) {
    service.addPet(index, pet);
  }


  public void showMenu() {
    StringBuilder sB = new StringBuilder();
    sB.append("1. **Fill with test data**\n")
            .append("2. **Show all families**\n")
            .append("3. **Show families which have members greater than specified number**\n")
            .append("4. **Show families which have members less than specified number**\n")
            .append("5. **Show families which have members with specified number**\n")
            .append("6. **Create new family**\n")
            .append("7. **Delete family**\n")
            .append("8. **Edit family**\n")
            .append("9. **Delete children above the specified age**\n")
            .append("10. **Exit**\n");
    System.out.println(sB);
  }

  public void caseOP1() {
    int hundred = 100;
    while (hundred-- > 0){
      Human father = new Man();
      Human mother = new Woman();
      father.setName(MaleName.randomName().name());
      mother.setName(FemaleName.randomName().name());
      father.setSurname(String.format("Surname%d", randID));
      mother.setSurname(String.format("Surname%d", randID));
      createNewFamily(father, mother);
      randID++;
    }
  }

  public void case2OP() {
    displayAllFamilies();
  }

  public void caseOP3() {
    System.out.println("Families \"bigger\" than: ");
    int num = Integer.parseInt(scan.nextLine());
    getFamiliesBiggerThan(num);
  }

  public void caseOP4() {
    System.out.println("Families \"smaller\" than: ");
    int num = Integer.parseInt(scan.nextLine());
    getFamiliesLessThan(num);
  }

  public void caseOP5() {
    System.out.println("Number of members: ");
    int num = Integer.parseInt(scan.nextLine());
    getFamiliesWithMembers(num);
  }

  public void caseOP6() {
    String motherName, fatherName, motherSurname, fatherSurname;
    int motherBirthYear, fatherBirthYear, motherBirthMonth, fatherBirthMonth, motherBirthDay, fatherBirthDay, motherIq, fatherIq;
    System.out.println("Enter mother name:");
    motherName = scan.nextLine();
    System.out.println("Enter mother surname:");
    motherSurname = scan.nextLine();
    System.out.println("Enter mother birth year:");
    motherBirthYear = Integer.parseInt(scan.nextLine());
    System.out.println("Enter mother birth month:");
    motherBirthMonth = Integer.parseInt(scan.nextLine());
    System.out.println("Enter mother birth day:");
    motherBirthDay = Integer.parseInt(scan.nextLine());
    System.out.println("Enter mother iq:");
    motherIq = Integer.parseInt(scan.nextLine());
    String format = String.format("%s/%s/%s", motherBirthDay, motherBirthMonth, motherBirthYear);
    Human mother = new Human(motherName, motherSurname, format, motherIq);

    System.out.println("Enter father name:");
    fatherName = scan.nextLine();
    System.out.println("Enter father surname:");
    fatherSurname = scan.nextLine();
    System.out.println("Enter father birth year:");
    fatherBirthYear = Integer.parseInt(scan.nextLine());
    System.out.println("Enter father birth month:");
    fatherBirthMonth = Integer.parseInt(scan.nextLine());
    System.out.println("Enter father birth day:");
    fatherBirthDay = Integer.parseInt(scan.nextLine());
    System.out.println("Enter father iq:");
    fatherIq = Integer.parseInt(scan.nextLine());
    String formatf = String.format("%s/%s/%s", fatherBirthDay, fatherBirthMonth, fatherBirthYear);
    Human father = new Human(fatherName, fatherSurname, formatf, fatherIq);

    createNewFamily(father, mother);
    /**- request for the mother's name
     - request mother's last name
     - request mother's birth year
     - request mother's month of birth
     - request mother's birthday
     - request mother's iq
     */
  }

  public void caseOP7() {
    System.out.println("Enter the family ID: ");
    int num = Integer.parseInt(scan.nextLine());
    deleteFamilyByIndex(num);
  }

  public void caseOP8() {
    StringBuilder sb = new StringBuilder();
    sb.append("1. Give birth to a baby\n")
            .append("2. Adopt a child\n")
            .append("3. Return to main menu");
    while (true) {
      System.out.println(sb);
      String choice = scan.nextLine();
      switch (choice) {
        case "1":
          System.out.println("Enter the family ID: ");
          String id = scan.nextLine();
          int iddd = Integer.parseInt(id);
          System.out.println("What is child's gender(masculine, feminine): ");
          String str = scan.nextLine();
          //**      Exception to gender */
          bornChild(service.getFamilyById(iddd), str);
          break;
        case "2":
          System.out.println("Enter the family ID: ");
          int idd = Integer.parseInt(scan.nextLine());
          System.out.println("What is child's name: ");
          String childName = scan.nextLine();
          System.out.println("What is child's surname: ");
          String childSurame = scan.nextLine();
          System.out.println("What is child's year of birth( DD/NM/YYYY ): ");
          String childbirthYear = scan.nextLine();
          System.out.println("What is child's iq level: ");
          int childiq = Integer.parseInt(scan.nextLine());
          //full name, year of birth, intelligence)
          Human child = new Human(childName, childSurame, childbirthYear, childiq);
          adoptChild(service.getFamilyById(idd), child);
          break;
        case "3":
          return;
        default:
          System.out.println("Wrong input. Try again!");
      }
    }
  }

  public void caseOP9() {
    System.out.println("Enter the age of children to remove: ");
    int age = Integer.parseInt(scan.nextLine());
    deleteAllChildrenOlderThen(age);
  }

}
