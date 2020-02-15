package hw03;

import java.util.*;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] schedule = new String[7][2];
        schedule[0][0]="Sunday";
        schedule[0][1]="Rest; Do homework";
        schedule[1][0]="Monday";
        schedule[1][1]="Learn to write code in Java; Go to course";
        schedule[2][0]="Tuesday";
        schedule[2][1]="Meeting with your team";
        schedule[3][0]="Wednesday";
        schedule[3][1]="Watch a film; Go to course";
        schedule[4][0]="Thursday";
        schedule[4][1]="Math learning with teacher";
        schedule[5][0]="Friday";
        schedule[5][1]="Learn about Game Development";
        schedule[6][0]="Saturday";
        schedule[6][1]="Try to create new app; Free time for team games";
        String userInput;
        do{
            System.out.println("Please, input the day of the week: ");
            userInput = scanner.nextLine();
            userInput = userInput.toLowerCase();
            userInput = userInput.trim();
            switch (userInput){
                case("sunday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[0][0],schedule[0][1]);
                    break;
                case ("monday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[1][0],schedule[1][1]);
                    break;
                case ("tuesday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[2][0],schedule[2][1]);
                    break;
                case ("wednesday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[3][0],schedule[3][1]);
                    break;
                case ("thursday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[4][0],schedule[4][1]);
                    break;
                case ("friday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[5][0],schedule[5][1]);
                    break;
                case ("saturday"):
                    System.out.printf("Your tasks for %s: %s.\n",schedule[6][0],schedule[6][1]);
                    break;
                case("exit"):
                        return;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }
        }
        while (true);


    }
}
