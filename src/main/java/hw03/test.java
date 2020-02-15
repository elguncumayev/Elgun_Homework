package hw03;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();
        userInput = userInput.trim();
        System.out.printf("00%s00",userInput);
    }
}
