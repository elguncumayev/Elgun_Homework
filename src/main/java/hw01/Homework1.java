package hw01;

import java.io.*;
import java.util.*;



public class Homework1 {
    public static void main(String[] args) {
        final int sizeOfArray = 100;

        Scanner scan = new Scanner(System.in);

        String name;
        System.out.print("Enter your name: ");
        name = scan.nextLine();

        int randNumber = (int) (Math.random()*(100+1));

        System.out.print("Let the game begin!\n" +
                "There is a hidden random number from 0 to 100. Try to guess it:\n");

        String userGuess;
        int userGuessNumber;
        int[] guessingNumbers = new int[100];
        int indexForArray = 0;

        while(true){

            try{
                userGuess = scan.nextLine();
                userGuessNumber = Integer.parseInt(userGuess);
                guessingNumbers[indexForArray] = userGuessNumber;
                indexForArray++;
                if(userGuessNumber > randNumber){
                    System.out.println("Your number is too big. Please, try again.");
                }
                else if(userGuessNumber < randNumber){
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
