package cosc237.lab1;
import java.util.Random;
import java.util.Scanner;

/**
 *     @author Ivan Goncharuk<br>
 *     COSC 237.001<br>
 *     LAB #1: LOOPS<br>
 *     Problem 1<br>
 *
 * <br>Task:
 *     Suppose you are writing a game-playing program that involves 2-digit numbers.
 *     First, generate a random 2-digit number. The user will try to guess this
 *     number in at most 10 attempts. While getting input from the user give a
 *     hint if a match was found (0/1/2 digits match).
 *     Test for errors in input (including type check).
 *     Use the sample output to fully understand the program requirements.
 */

public class GuessingGame {
    private static final int MIN = 10;
    public static void main(String[] args) {
        final int MAX = 99;
        Random rand = new Random();

        // Generating a random 2-digit number 10-99
        // Random with bounds:      .nextInt((MAX - MIN) + 1) + MIN
        int targetNum = rand.nextInt((MAX - MIN) + 1) + MIN;
        //System.out.println("TARGET NUMBER: " + targetNum);
        int guess;
        int digitsMatched = 0;
        Scanner input = new Scanner(System.in);

        // Instructions
        System.out.println("Try to guess my secret two-digit number, and I'll tell you how\n" +
                           "many digits from your guess appear in my number. \n" +
                           "\n" +
                           "Be smart! You can try at most 10 times.");

        for (int i = 1; i <= 10; i++) {

            guess = typeCheckInt(input);
            System.out.println("Your guess: " + guess);

            // checking first and second digit of the user's guess against the tens place of targetNum
            if (guess / 10 == targetNum / 10 || guess % 10 == targetNum / 10) {
                digitsMatched++;
            }
            // checking first and second digit of the user's guess against the ones place of targetNum
            if (guess / 10 == targetNum % 10 || guess % 10 == targetNum % 10) {
                digitsMatched++;
            }
            /*  In case the targetNum has two of the same digits, I do not want
                the compiler to count the occurrence twice. The first comparison checks
                if there's no matches, so I don't return a negative number. */
            if (digitsMatched > 0 && (targetNum % 10 == targetNum / 10)) {
                digitsMatched--;
            }


            if (guess == targetNum) {
                System.out.println("You guessed my number in " + i + " tries!");
                break;
            } else {
                System.out.println("Incorrect (hint: " + digitsMatched + " digits match)");
                digitsMatched = 0;
            }
        }
    }

    /**
     * Checks if the input passed in is an integer. It also checks if the input has two characters (digits).
     * Method will infinitely loop asking for input if it does not match the criteria (must be an int and no more
     * or less than two characters).
     * @param input The scanner input you're trying to type check
     * @return The input as an integer.
     */
    private static int typeCheckInt(Scanner input) {
        // Type Checking
        String inputString;
        boolean b = true;
        int result = 0;
        while (b) {
            inputString = input.nextLine();
            try {
                result = Integer.parseInt(inputString);
                if (inputString.length() != 2) {
                    System.out.println("Only two digits! Try again: ");
                } else {
                    b = false;
                }
            } catch (Exception e) {
                System.out.println("Not an Integer! Try again: ");
            }
        }
        return result;
    }
}
