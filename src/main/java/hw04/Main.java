package hw04;

public class Main {
    public static void main(String[] args) {
        Human johnSmith = new Human();
        Human aliceSmith = new Human("Alice","Smith",1975);
        Human oliviaSmith = new Human("Olivia","Smith",1996,johnSmith,aliceSmith);
        Pet davidDog = new Pet();
        String[][] davidSchedule = {{"Sunday","do homework"},{"Monday","go to course"}};
        Human davidSmith = new Human("David","Smith",1998,87,davidDog,johnSmith,aliceSmith,davidSchedule);
        Pet oliviaCat = new Pet("Cat","Puffy");
        String[] aliceDogHabits = {"sleep","play"};
        Pet aliceDog = new Pet("Dog","Marshmallow",3,68,aliceDogHabits);
        johnSmith.name = "John";
        johnSmith.surname = "Smith";
        johnSmith.dateOfBirth = 1973;
        johnSmith.iqLevel = 93;
        johnSmith.pet = new Pet();
        johnSmith.father = new Human();
        johnSmith.mother = new Human();
        johnSmith.schedule = new String[7][2];
        aliceSmith.iqLevel = 91;
        aliceSmith.pet = aliceDog;
        aliceSmith.father = new Human();
        aliceSmith.mother = new Human();
        aliceSmith.schedule = new String[7][2];
        oliviaSmith.iqLevel = 88;
        oliviaSmith.pet = oliviaCat;
        oliviaSmith.schedule = new String[7][2];
        davidDog.species = "Dog";
        davidDog.nickname = "Rocky";
        davidDog.age = 4;
        davidDog.trickLevel = 48;
        davidDog.habits = new String[]{"run", "play"};
        System.out.println(davidSmith.toString());
        davidSmith.greetPet();
        davidSmith.describePet();
        System.out.println(aliceDog.toString());
        aliceDog.respond();
        aliceDog.eat();
        aliceDog.foul();

    }
}
