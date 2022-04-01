package cosc237.assignments.number2;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;

public class ComplexClient {

    public static void main(String[] args) {
        final String enterComplex = "Enter complex number (real imaginary): ";
        final String notValidInput = "Some inputs are not valid, initializing to (0, 0)";
        final String[] optionList = {
                "Add 2 complex numbers",
                "Subtract 2 complex numbers",
                "Multiply 2 complex numbers",
                "Divide 2 complex numbers",
                "Absolute value of a complex number",
                "Compare 2 complex numbers",
                "Display complex number in a + bi"  //just for fun
        };
        int option;
        int counter = 0;
        do {
            menu(optionList, "Your options for Complex arithmetic are:");
            option = getInput("\nPlease enter your option: ", "Not an integer! Try again: ", Integer::parseInt);
            Complex c1 = null;
            Complex c2 = null;
            boolean shouldDisplayAndIncrementCtr = true;
            if (option >= 1 && option <= 6) {                       // Refactored cases 1-6 to save paper
                c1 = Complex.read(enterComplex, notValidInput);
                if (option != 5) {
                    c2 = Complex.read(enterComplex, notValidInput);
                    out.printf("First complex number is: %s", c1);
                    out.printf("\nSecond complex number is: %s", c2);
                } else
                    out.printf("The complex number is: %s\n", c1);
            }
            switch (option) {
                case 0: // exit
                    out.println("Testing completed.");
                    return;
                case 1: // add
                    out.printf("\nResult: %s + %s = %s", c1, c2, c1.add(c2));
                    break;
                case 2: // subtract
                    out.printf("\nResult: %s - %s = %s", c1, c2, c1.subtract(c2));
                    break;
                case 3: // multiply
                    out.printf("\nResult: %s * %s = %s", c1, c2, c1.multiply(c2));
                    break;
                case 4: // divide
                    out.printf("\nResult: %s / %s = %s", c1, c2, c1.divide(c2));
                    break;
                case 5: // absolute value
                    out.printf("Result: |%s| = %f\n", c1, c1.cAbs());
                    break;
                case 6:
                    out.printf("\nThe complex numbers are%s equal.", c1.equals(c2) ? "" : " NOT");
                    break;
                case 7:
                    c1 = Complex.read(enterComplex, notValidInput);
                    out.printf("Result in a + bi:\n %s", c1.toStandard());
                    break;
                default:
                    out.println("\t\tNot an option!\n");
                    shouldDisplayAndIncrementCtr = false;
                    break;
            }
            if (shouldDisplayAndIncrementCtr) {
                counter++;
                out.printf("\n\tCommand number %d completed.\n\n", counter);
            }
        } while (true);
    }


    /**
     * Generic method to validate any input.
     *
     * @param prompt The string used to prompt the user to input something
     * @param errMsg The string used to spit out a desired error message for invalid inputs
     * @param parse  A generic Function that takes two parameters, a String type and a generic type T.
     *               The String is for the class, and T is the return type of the method. It will
     *               {@code try} to execute that method, and will throw an exception if the string
     *               the method is trying to parse cannot be done.</p>
     *               <p>
     *               For instance, you can validate numbers...   <br>
     *               {@code int n = getInput("...", "...", Integer::parseInt);}  <br>
     *               {@code double d = getInput("...", "...", Double::parseDouble);}  <br>
     *               The method must throw an exception in order
     * @param <T>    The method that will throw an exception for invalid inputs in which this method will handle.
     * @return The validated desired return type
     */
    private static <T> T getInput(String prompt, String errMsg, Function<String, T> parse) {
        Scanner scan = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print(prompt);
            str = scan.next();
            try {
                return parse.apply(str);
            } catch (Exception e) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Method to print a menu with a dynamic set of options.
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
    }
}