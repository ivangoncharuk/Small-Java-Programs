package cosc237.assignments.number1;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ivan Goncharuk
 * @author Ryan Fitzpatrick
 * @author Million Abiyoto
 */
public class MatrixProcessing {
    public static final int GENERATE_MIN = 1;
    public static final int GENERATE_MAX = 10;

    public static void main(String[] args) {
        // DECLARATIONS
        String enterSize = "Enter the size of square matrices: ";
        String notAnIntMsg = "Not an integer, try again: ";
        int option;
        int squareMatrixSize;
        int ctr = 0;
        int[][] firstMatrix;
        int[][] secondMatrix;

        while (true) {
            menu();
            option = getInt("Please enter your option: ", notAnIntMsg, false);
            System.out.println();

            switch (option) {
                case 0:
                    System.out.println("Testing completed.");
                    return;
                case 1:
                    squareMatrixSize = getInt(enterSize, notAnIntMsg, true);
                    firstMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    secondMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    System.out.println("First matrix is: ");
                    print(firstMatrix);
                    System.out.println("Second matrix is: ");
                    print(secondMatrix);
                    System.out.println("The resulting matrix is: ");
                    print(Objects.requireNonNull(addMatrix(firstMatrix, secondMatrix)));
                    break;
                case 2:
                    squareMatrixSize = getInt(enterSize, notAnIntMsg, true);
                    firstMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    secondMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    System.out.println("First matrix is: ");
                    print(firstMatrix);
                    System.out.println("Second matrix is: ");
                    print(secondMatrix);
                    System.out.println("The resulting matrix is: ");
                    print(Objects.requireNonNull(subtractMatrix(firstMatrix, secondMatrix)));
                    break;
                case 3:
                    squareMatrixSize = getInt(enterSize, notAnIntMsg, true);
                    firstMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    secondMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    System.out.println("First matrix is: ");
                    print(firstMatrix);
                    System.out.println("Second matrix is: ");
                    print(secondMatrix);
                    System.out.println("The resulting matrix is: ");
                    print(multiply(firstMatrix, secondMatrix));
                    break;
                case 4:
                    squareMatrixSize = getInt(enterSize, notAnIntMsg, true);
                    firstMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    int scalar = getInt("Enter the multiplication constant: ", notAnIntMsg, false);
                    System.out.println("The matrix is: ");
                    print(firstMatrix);
                    System.out.printf("The original matrix multiplied by %d is: \n", scalar);
                    print(multiplyBy(firstMatrix, scalar));
                    break;
                case 5:
                    squareMatrixSize = getInt(enterSize, notAnIntMsg, true);
                    firstMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    System.out.println("The matrix is: ");
                    print(firstMatrix);
                    secondMatrix = transpose(firstMatrix);
                    System.out.println("The transposed matrix is: ");
                    print(secondMatrix);
                    break;
                case 6:
                    squareMatrixSize = getInt(enterSize, notAnIntMsg, true);
                    firstMatrix = generateSquareMatrix(squareMatrixSize, GENERATE_MIN, GENERATE_MAX);
                    System.out.println("The matrix is: ");
                    print(firstMatrix);
                    System.out.printf("The trace for this matrix is %d.\n", matrixTrace(firstMatrix));
                    break;
                default:
                    System.out.println("Not an option.");
                    ctr--;
                    break;
            }
            String spacer = "\t\t\t\t\t\t\t";
            ctr++;
            System.out.printf("%sCommand number %d completed.\n\n", spacer, ctr);
        }
    }

    /**
     * Prints the menu.
     */
    public static void menu() {
        System.out.println("Your options are:\n" +
                           "-----------------\n" +
                           "        1) Add 2 matrices\n" +
                           "        2) Subtract 2 matrices\n" +
                           "        3) Multiply 2 matrices\n" +
                           "        4) Multiply matrix by a constant\n" +
                           "        5) Transpose matrix\n" +
                           "        6) Matrix trace\n" +
                           "        0) EXIT");
    }

    /**
     * Gets an integer input from user. Returns the input if the input
     * is an integer. If not an integer, an error message will display to the console.
     *
     * @param prompt  The prompt used to ask the user for the input.
     * @param errMsg  The error message displayed when the user enters an invalid input.
     * @param onlyPos {@code true} to also ensure that a positive integer is entered.
     * @return An integer entered by the user.
     */
    public static int getInt(String prompt, String errMsg, Boolean onlyPos) {
        Scanner userInput = new Scanner(System.in);
        int result;
        String str;
        while (true) {
            System.out.print(prompt);
            str = userInput.next();
            try {
                result = Integer.parseInt(str);
                if (onlyPos && result < 0) {
                    System.out.println("Only Positive Values");
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Generates a two-dimensional array. The array is populated with random integers with a maximum and
     * minimum bounds. The array has the same number of rows and columns.
     *
     * @param size The size of the rows and columns of the array.
     * @param max  The maximum bound of the randomly generated integer.
     * @param min  The minimum bound of the randomly generated integer.
     * @return A two-dimensional array (matrix) initialized with random numbers.
     */
    public static int[][] generateSquareMatrix(int size, int min, int max) {
        int[][] mat = new int[size][size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = r.nextInt(((max - min) + 1) + min);
            }
        }
        return mat;
    }

    /**
     * Prints a two-dimensional array.
     *
     * @param mat A two-dimensional integer array.
     */
    public static void print(int[][] mat) {
        for (int[] row : mat) {
            for (int rowElement : row)
                System.out.printf("%4d", rowElement);
            System.out.println();
        }
    }

    /**
     * Matrix addition. Adds elements from both two-dimensional integer arrays together into a third two-dimensional
     * array.
     *
     * @param mat1 The first two-dimensional integer array.
     * @param mat2 The second two-dimensional integer array.
     * @return A two-dimensional integer array that is the sum of two two-dimensional integer arrays.
     */
    public static int[][] addMatrix(int[][] mat1, int[][] mat2) {
        int rows = mat1.length, cols = mat1[0].length;
        if (mat2.length != rows && mat2[0].length != cols) {
            System.out.println("ERROR: Both matrices must have have same number of rows/cols.");
            return null;
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = mat1[i][j] + mat2[i][j];
        return result;
    }

    /**
     * Matrix subtraction. The result is the first matrix minus the second matrix.
     *
     * @param mat1 The first two-dimensional integer array.
     * @param mat2 The second two-dimensional integer array.
     * @return A two-dimensional integer array that is the result of subtracting the two matrices.
     */
    public static int[][] subtractMatrix(int[][] mat1, int[][] mat2) {
        int rows = mat1.length, cols = mat1[0].length;
        if (mat2.length != rows && mat2[0].length != cols) {
            System.out.println("ERROR: Both matrices must have have same number of rows/cols.");
            return null;
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = mat1[i][j] - mat2[i][j];
        return result;
    }

    //TODO: Apparently, this is not matrix multiplication. Update is needed.
    /**
     * Performs matrix multiplication on one matrix to another. To multiply two matrices together,
     * the number of columns in the first matrix must equal the number of rows of the second. Then,
     * multiply each element of each row of the first matrix, by each element of each column of the second.
     * Each element in the new matrix will be the result of multiplying the rows by columns.
     * For example, An element of the index [2][3] in the resulting matrix would be the sum of each element
     * of row index 2 multiplied by each element of the first matrix and each element of column 3 of the second matrix.
     *
     * @param mat1 The first matrix
     * @param mat2 The second matrix
     * @return The dot product of the first matrix by the second matrix
     */
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        if (mat1 != null && mat2 != null) {
            int[][] result = new int[mat1.length][mat2[0].length];
            if (mat1[0].length == mat2.length)
                for (int i = 0; i < mat1.length; i++)
                    for (int j = 0; j < mat2[0].length; j++)
                        result[i][j] = mat1[i][j] * mat2[j][i];
            return result;
        }
        return new int[0][0];
    }

    /**
     * Multiplies each element in a two-dimensional integer array by a scalar.
     *
     * @param mat    A two-dimensional integer array.
     * @param scalar The constant that is multiplied by each element of the array.
     * @return A two-dimensional array that is the result of multiplying each element
     * of the array by a constant.
     */
    public static int[][] multiplyBy(int[][] mat, int scalar) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = mat[i][j] * scalar;
        return result;
    }

    /**
     * Swaps all columns in a two-dimensional integer array with its rows.
     *
     * @param mat A two-dimensional integer array
     * @return A new transposed two-dimensional integer array
     */
    public static int[][] transpose(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                result[i][j] = mat[j][i];
        return result;

    }

    /**
     * Performs a matrix trace on a two-dimensional integer array.
     * A matrix trace is the sum of all the diagonal elements of an array.
     *
     * @param mat The two-dimensional integer array
     * @return The trace for the two-dimensional integer array
     */
    public static int matrixTrace(int[][] mat) {
        if (mat != null) {
            int result = mat[0][0];
            for (int i = 1; i < mat.length; i++)
                result += mat[i][i];
            return result;
        }
        return 0;
    }
}