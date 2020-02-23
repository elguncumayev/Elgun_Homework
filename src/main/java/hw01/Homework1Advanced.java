package hw01;

import java.util.Arrays;
import java.util.Scanner;

public class Homework1Advanced {
    public static void main(String[] args) {
        final int sizeOfArray = 1000;
        Scanner scan = new Scanner(System.in);
        String[][] Years = {{"When did the World War II begin?","1939"},
                {"When did Christopher Columbus discovers the New World?","1492"},
                {"When did Vasco da Gama discovers the sea route from Europe to India?","1498"},
                {"When did the First modern Olympic Games hold at Athens?","1896"},
                {"When did 1st World War end?","1918"},
                {"Which year was the beginning of the French Revolution?","1789"}};
        String name;
        System.out.print("Enter your name: ");
        name = scan.nextLine();

        int randEvent = (int) (Math.random()*(5+1));
        int yearOfRandEvent = Integer.parseInt(Years[randEvent][1]);

        System.out.printf("Let the game begin!\n%s\n",Years[randEvent][0]);

        String userGuess;
        int userGuessNumber;
        int[] guessingNumbers = new int[1000];
        int indexForArray = 0;

        while(true){

            try{
                userGuess = scan.nextLine();
                userGuessNumber = Integer.parseInt(userGuess);
                guessingNumbers[indexForArray] = userGuessNumber;
                indexForArray++;
                if(userGuessNumber > yearOfRandEvent){
                    System.out.println("Your number is too big. Please, try again.");
                }
                else if(userGuessNumber < yearOfRandEvent){
                    System.out.println("Your number is too small. Please, try again.");
                }
                else{
                    break;
                }
            }
            catch(Exception e){
                System.out.println("Please enter a number.");
            }

        }

        Arrays.sort(guessingNumbers);

        int[] newSortedArray = new int[indexForArray];

        for (int i = 0; i < indexForArray; i++) {
            newSortedArray[i]=guessingNumbers[sizeOfArray-1-i];
        }

        System.out.printf("Congratulations, %s!\nYour numbers: %s",name,Arrays.toString(newSortedArray));
    }
}