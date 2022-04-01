package cosc237.lab12;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;
import static cosc237.lab12.Lab12.*;

/*
Write a program to do the testing for the following methods. Make sure you also have a method to handle input
validation (positive integer, n > 0).
1. A method to find the sum of digits in any integer (iterative method)
2. A method to find the sum of digits in any integer (recursive method)
3. A method to display a number in binary (iterative method)
4. A method to display a number in binary (recursive method)
5. A method to return the string representation of a number in any base (iterative method)
6. A method to return the string representation of a number in any base (recursive method)
 */
public class Client implements Lab12 {
    static final String[] options = {
            "Find the sum of digits in any integer (iterative)",
            "Find the sum of digits in any integer (recursive)",
            "Display a number in binary (iterative)",
            "Display a number in binary (recursive)",
            "String representation of a number in any base (iterative)",
            "String representation of a number in any base (recursive)"
    };

    public static void main(String[] args) {
        int choice;
        String notAnIntErrMsg = "Err, not an int";

        menu(options, "Choose any integer menu item to leetcode.test: ");
        choice = getInput("", notAnIntErrMsg, Integer::parseInt);
        while (choice != 0) {
            int n = getInput("Enter an integer n: ", notAnIntErrMsg, Integer::parseInt);
            int base;
            switch (choice) {
                case 1:
                    out.println(sumOfDigits(n));
                    break;
                case 2:
                    out.println(sumOfDigitsRecursive(n));
                    break;
                case 3:
                    displayBinary(n);
                    break;
                case 4:
                    displayBinaryRecursive(n);
                    break;
                case 5:
                    base = getInput("Enter a base integer: ", notAnIntErrMsg, Integer::parseInt);
                    displayAnyBase(n, base);
                    break;
                case 6:
                    base = getInput("Enter a base integer: ", notAnIntErrMsg, Integer::parseInt);
                    displayAnyBaseRecursive(n, base);
                    break;
            }
            menu(options, "Choose any integer menu item to leetcode.test: ");
            choice = getInput("", "ERR", Integer::parseInt);
        }
        out.println("Program Exited.");
    }


    private static <T> T getInput(String prompt, String errMsg, Function<String, T> parse) {
        Scanner scan = new Scanner(System.in);
        String str;
        while (true) {
            out.print(prompt);
            str = scan.next();
            try {
                return parse.apply(str);
            } catch (Exception e) {
                out.print(errMsg);
            }
        }
    }

    /**
     * Method to print a menu with a flexible set of options.
     *
     * @param optionList A string array which holds all the menu options
     * @param title      The title for this menu
     */
    private static void menu(String[] optionList, String title) {
        out.println(title);
        for (int i = 0; i < title.length(); i++) {
            out.print("-");
        }
        out.println();
        for (int i = 0; i < optionList.length; i++) {
            out.printf("\t%d) %s\n", i + 1, optionList[i]);
        }
        out.println("\t0) EXIT");
        out.print("Please enter your option: ");
    }

}
