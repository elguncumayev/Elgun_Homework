package hw02;

import java.util.Arrays;
import java.util.Scanner;

public class Homework2 {
    public static void display(char[][] board){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%c ",board[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Exception exception = new Exception();
        Scanner scan = new Scanner(System.in);
        char[][] board = new char[6][6];
        //creating board
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(i==0){
                    board[i][j]= (char) (j+48);
                }
                else if (j==0){
                    board[i][j] = (char) (i+48);
                }
                else {
                    board[i][j] = '-';
                }
            }
        }
        //random target position
        int targetx = (int) (Math.random()*(5)+1);
        int targety = (int) (Math.random()*(5)+1);
        System.out.println("All set. Get ready to rumble!");
        String userGuessx,userGuessy;
        int userGuessxNum = 0,userGuessyNum = 0;
        boolean flagX=false,flagY=false;
        while(true){
            if(!flagY || !flagX){
                try{
                    if (!flagY) {
                        System.out.println("Enter Y of your shot: ");
                        userGuessy = scan.nextLine();
                        userGuessyNum = Integer.parseInt(userGuessy);
                        if (userGuessyNum < 1 || userGuessyNum > 5) {
                            throw exception;
                        }
                        flagY = true;
                    }
                    if (!flagX){
                        System.out.println("Enter X of your shot: ");
                        userGuessx = scan.nextLine();
                        userGuessxNum = Integer.parseInt(userGuessx);
                        if(userGuessxNum<1 || userGuessxNum>5){
                            throw exception;
                        }
                        flagX=true;
                    }
                }
                catch(Exception e){
                    System.out.println("Please enter a number from 1 to 5:");
                }
            }
            else if (flagY && flagX){
                if (targetx == userGuessxNum && targety==userGuessyNum){
                    board[targety][targetx] = 'x';
                    display(board);
                    break;
                    }
                else{
                    board[userGuessyNum][userGuessxNum] = '*';
                    display(board);
                    flagX=false;
                    flagY=false;
                }

            }
        }
        System.out.println("You have won!");
    }

}
/*
for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%c ",board[i][j]);
            }
            System.out.println();
        } */