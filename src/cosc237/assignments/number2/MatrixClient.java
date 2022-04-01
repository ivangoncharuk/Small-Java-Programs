package cosc237.assignments.number2;

import java.util.Scanner;

import static java.lang.System.out;

public class MatrixClient {
    public static final int MAX = 20;
    public static final int MIN = 2;
    public static final int LOW = 1;
    public static final int UP = 10;
    private static final String title = "\nYour options for Matrix Processing are:";
    private static final String[] optionList = {
            "Add 2 matrices",
            "Subtract 2 matrices",
            "Multiply 2 matrices",
            "Multiply matrix by a constant",
            "Transpose matrix",
            "Matrix trace",
            "Make a copy",
            "Test for equality"
    };
    public static int commandNumber = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice; //operation to be executed from menu
        int numCommands = 0; //display counter
        int size; //for subarray processing
        int value; //multiply matrix by this scalar
        int tr; //return from trace()

        System.out.print("Enter the size of the square matrix: ");
        size = getInt(input);
        while (size < MIN || size >= MAX) {
            System.out.println("Invalid size. Must be from " + MIN + " to " + MAX + ".");
            System.out.print("Enter the size of the square matrix: ");
            size = getInt(input);
        }
        Matrix first = new Matrix(size);
        Matrix second = new Matrix(size);
        Matrix result;

        while (true) {
            menu();
            System.out.print("\nPlease enter your option: ");
            choice = getInt(input);
            while (choice < 0 || choice > optionList.length + 1) {
                System.out.print("Not an option. Try again: ");
                choice = getInt(input);
            }

            switch (choice) {
                case 1:
                    result = first.add(second);
                    out.println("First matrix is: ");
                    first.print();
                    out.println("Second matrix is: ");
                    second.print();
                    out.println("The resulting matrix is: ");
                    result.print();
                    break;
                case 2:
                    result = first.subtract(second);
                    out.println("First matrix is: ");
                    first.print();
                    out.println("Second matrix is: ");
                    second.print();
                    out.println("The resulting matrix is: ");
                    result.print();
                    break;
                case 3:
                    result = first.multiply(second);
                    out.println("First matrix is: ");
                    first.print();
                    out.println("Second matrix is: ");
                    second.print();
                    out.println("The resulting matrix is: ");
                    result.print();
                    break;
                case 4:
                    out.print("Enter the multiplication constant: ");
                    value = getInt(input);
                    out.println("The original matrix is: ");
                    first.print();
                    result = first.multiplyConst(value);
                    out.println("The resulting matrix is: ");
                    result.print();
                    break;
                case 5:
                    out.println("The original matrix is: ");
                    first.print();
                    out.println("The resulting matrix is: ");
                    result = first.transpose();
                    result.print();
                    break;
                case 6:
                    out.println("The original matrix is: ");
                    first.print();
                    System.out.println("The trace for this matrix is: " +first.trace());
                    break;
                case 7:
                    out.println("The original matrix is: ");
                    first.print();
                    Matrix tempMatrix = new Matrix(first);
                    out.println("The copy of this matrix is: ");
                    tempMatrix.print();
                    out.println("Testing for equality. Should be equal!!");
                    if(first.equals(tempMatrix)){
                        out.println("The matrices are equal!!");
                    } else{
                        out.println("The matrices are NOT equal!!");
                    }
                    break;
                case 8:
                    out.println("First matrix is: ");
                    first.print();
                    out.println("Second matrix is: ");
                    second.print();
                    if(first.equals(second)){
                        out.println("The matrices are equal!!");
                    } else{
                        out.println("The matrices are NOT equal!!");
                    }
                    break;
                case 0:
                    out.println("Program exited. Thank you.");
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
            System.out.println("\tCommand number " + commandNumber++ + " completed.");
        }
    }

    private static void menu() {
        menu(optionList, title);
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

    // Retrieves a valid integer from the user, repeating retrieving input until an integer is entered
    public static int getInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Not an integer! Try again: ");
            input.next();
        }
        return input.nextInt();
    }
}
