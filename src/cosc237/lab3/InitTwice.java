package cosc237.lab3;

import java.util.Random;
import java.util.Scanner;

public class InitTwice {
    public static final int MIN_ARRAY_SIZE = 1;
    public static final int MAX_ARRAY_SIZE = 100;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String choice;
        int arraySize;
        int[] originalArray;
        int[] secondArray;
        boolean start;

        System.out.print("Start (y/n): ");
        choice = userInput.next();
        start = choice.equalsIgnoreCase("Y");
        while (start) {
            do arraySize = getInt(userInput, "How many elements/array: ", "Not an integer! Try again!");
            while (arraySize < 0);
            originalArray = initRand(arraySize, MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
            secondArray = twice(originalArray, arraySize);
            System.out.println("The original array is: ");
            print(originalArray);
            System.out.println("The second array is: ");
            print(secondArray);
            System.out.print("Continue(y/n): ");
            choice = userInput.next();
            start = choice.equalsIgnoreCase("Y");
        }
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
        int result;
        String str;
        while (true) {
            System.out.print(prompt);
            str = userInput.next();
            try {
                result = Integer.parseInt(str);
                return result;
            } catch (Exception e) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Initializes an array with random numbers with bounds.
     *
     * @param length Number of elements in the array
     * @param max    The maximum bound of the random number generation.
     * @param min    The minimum bound of the random number generation.
     * @return A one dimensional array filled with random numbers.
     */
    public static int[] initRand(int length, int min, int max) {
        if (length <= 0)
            return new int[]{};
        Random r = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = r.nextInt((max + 1) - min) + min;
        return arr;
    }

    /**
     * Prints all the elements of an array.
     *
     * @param arr The array to be printed.
     */
    public static void print(int[] arr) {
        for (int i : arr)
            System.out.printf("%4d", i);
        System.out.println();
    }

    /**
     * Creates a new array holding two copies of each element in the original array
     *
     * @param arr  The original array.
     * @param size The size of the original array.
     * @return The new array holding two copies of each element from the array passed in.
     */
    public static int[] twice(int[] arr, int size) {
        int newSize = size * 2;
        int[] newArr = new int[newSize];
        for (int i = 0; i < newSize; i++)
            newArr[i] = arr[i / 2];
        return newArr;
    }
}
