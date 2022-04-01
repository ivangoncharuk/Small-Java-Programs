package cosc237.lab1;

import java.util.Scanner;

/**
 *     @author Ivan Goncharuk<br>
 *     COSC 237.001<br>
 *     LAB #1: LOOPS<br>
 *     Problem 1<br>
 *
 * <br>Task:
 *     Use nested for loops statements to draw empty boxes of any character (user input).<br>
 *     The boxes have the same number of rows and columns (user input - valid range: 5 to 21).<br>
 *     Test for errors in input (including type). Use the sample output to fully understand
 *     the program requirements.
 */

public class DrawEmptyBoxes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ch;
        String yesOrNo; // I think this name is stupid but I can't think of anything better.
        String str;
        int numOfChars;

        System.out.print("Do you want to start(Y/N): ");
        yesOrNo = input.next();
        while (yesOrNo.equals("Y") || yesOrNo.equals("y")) {

            System.out.print("\nHow many chars/last row? ");
            do {
                str = input.next();
            } while ( !(isStringAnInt(str)) );
            numOfChars = Integer.parseInt(str);

            System.out.print("\nWhat character? ");
            ch = input.next().charAt(0);

            drawBox(numOfChars, ch);

            System.out.print("\nDo you want to continue(Y/N): ");
            yesOrNo = input.next();
        }
        input.close();
    }

    /**
     * Will determine whether the string passed in is an Int and in the valid range (5 to 21).
     * @param s The string you are checking.
     * @return True if the string passed is an int. False if the string is<br>
     *         not an int and within the valid range (5 to 21)
     */
    private static boolean isStringAnInt(String s) {
        try {
            int n = Integer.parseInt(s);
            if (n < 5 || n > 21) {
                System.out.print("ERROR! Valid range 5 - 21. ");
                System.out.print("How many chars/last row? ");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.print("Not an integer! Try again! ");
            System.out.print("How many chars/last row? ");
            return false;
        }
    }

    /**
     * Draws a square of characters.
     * @param numOfChars The number of characters used for both dimensions of the square.<br>
     *                   Valid range: 5 to 21
     * @param c The character used to draw the box
     */
    private static void drawBox(int numOfChars, char c) {
        // Top row
        for (int i = 0; i < numOfChars; i++) {
            System.out.print(c);
        }
        System.out.println();

        // Middle part
        for (int i = 0; i < numOfChars - 2; i++) {
            System.out.print(c);
            // print the spaces in between
            for (int j = 0; j < numOfChars - 2; j++) {
                System.out.print(" ");
            }
            System.out.println(c);
        }

        // Bottom row
        for (int i = 0; i < numOfChars; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
}