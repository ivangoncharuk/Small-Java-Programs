package cosc237.lab3;

import java.util.Random;
import java.util.Scanner;

/**
 * Asks the user for a row and column value for a two-dimensional integer array to be filled with random integers
 * between 0 and 1.
 */
public class FindFlippedRows {
    public static final int MIN = 0;
    public static final int MAX = 1;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String errMsg = "Not an integer! Try again! ";
        boolean start;
        int[][] mat;
        int rows;
        int cols;

        System.out.print("Do you want to start(Y/N): ");
        start = userInput.next().equalsIgnoreCase("Y");
        while (start) {
            rows = getInt(userInput, "How many rows: ", errMsg);
            cols = getInt(userInput, "How many columns: ", errMsg);
            mat = initRand(rows, cols, MIN, MAX);
            System.out.println("The matrix is: ");
            print(mat);
            findFlippedRows(mat, rows);
            System.out.println("\nDo you want to continue(Y/N): ");
            start = userInput.next().equalsIgnoreCase("Y");
        }
    }

    /**
     * Generates a two-dimensional array. The array is populated with random integers with a maximum and
     * minimum bounds. The array has the same number of rows and columns.
     *
     * @param max The maximum bound of the randomly generated integer.
     * @param min The minimum bound of the randomly generated integer.
     * @return A two-dimensional array (matrix) initialized with random numbers.
     */
    public static int[][] initRand(int rows, int cols, int min, int max) {
        int[][] mat = new int[rows][cols];
        Random r = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = r.nextInt((max + 1) - min) + min;
        return mat;
    }

    /**
     * Gets an integer input from user. Returns the input if the input
     * is an integer. If not an integer, an error message will display to the console.
     *
     * @param userInput Scanner object to get input from the user.
     * @param prompt    The prompt used to ask the user for the input.
     * @param errMsg    The error message displayed when the user enters an invalid input.
     * @return An integer entered by the user.
     */
    public static int getInt(Scanner userInput, String prompt, String errMsg) {
        String str;
        while (true) {
            System.out.print(prompt);
            str = userInput.next();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Prints a two-dimensional array. The row index also prints in front of each row.<br>
     * Sample output for a {@code new int[5][4]} with random initialized values:<br>
     *   [0]    1    1    0    1<br>
     *   [1]    1    1    0    1<br>
     *   [2]    0    1    1    1<br>
     *   [3]    1    1    1    0<br>
     *   [4]    0    1    0    0<br>
     *
     * @param mat A two-dimensional integer array.
     */
    public static void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            //The "[n]"th element of the array will be printed in front
            System.out.printf(i < 10 ? "  [%d]" : i < 100 ? " [%d]" : "[%d]", i);
            for (int j = 0; j < mat[i].length; j++)
                System.out.printf("%5d", mat[i][j]);
            System.out.println();
        }
    }

    /**
     * Determines whether two arrays are flipped versions of each other. An array is considered <i>flipped</i>
     * when the array is exact copy of the first array when iterated through backwards.
     * Example: The array, {1, 2, 3, 4, 5}, and {5, 4, 3, 2, 1}, would return {@code true} because
     * they are flipped versions of each other.
     * If either of the arrays are empty, method will return {@code false}
     *
     * @param arr1 The original array.
     * @param arr2 The array you are comparing the original array to.
     * @return {@code true} if the array second array is a flipped version of the first array.
     */
    public static boolean isArrayFlipped(int[] arr1, int[] arr2) {
        if (arr1 != null && arr2 != null) { // if either of the arrays are null, return false
            int arrLength = arr1.length;
            // check if they have two different lengths
            if (arrLength != arr2.length) return false;

            // algorithm that checks equality of its element against the other array iterated backwards.
            // if they're not equal, return false, else, return true
            for (int i = 0; i < arrLength; i++)
                if (arr1[i] != arr2[arrLength - 1 - i])
                    return false;
            return true;
        } else
            return false;
    }

    /**
     * Creates an array that is a copy of a specified row in a two-dimensional integer array.
     * @param mat A two-dimensional integer array
     * @param rowIndex The row to be copied
     * @return The specified row of a two-dimensional array.
     */
    public static int[] getRow(int[][] mat, int rowIndex) {
        int rowLength = mat[rowIndex].length;
        int[] result = new int[rowLength];
        for (int i = 0; i < rowLength; i++)
            result[i] = mat[rowIndex][i];
        return result;
    }

    /**
     * A method that prints all the rows and their indexes that are <i>flipped</i>
     * inside a two-dimensional integer array.
     * @param mat A two-dimensional integer array.
     * @param rows The length of the two-dimensional array.
     */
    public static void findFlippedRows(int[][] mat, int rows) {
        if (mat != null)
            //int rows = mat.length; // uncomment to not use an extra param in method signature, add {}'s
            for (int i = 0; i < rows - 1; i++)
                for (int j = i + 1; j < rows; j++)
                    if (isArrayFlipped(getRow(mat, i), getRow(mat, j)))
                        System.out.printf("Rows index [%d] and [%d] are flipped.\n", i, j);
    }
}