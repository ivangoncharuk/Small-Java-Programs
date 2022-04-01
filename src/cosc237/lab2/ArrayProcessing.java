package cosc237.lab2;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

//TASK ONE
public class ArrayProcessing {
    public static final int MAX_ARR_SIZE = 100;
    public static final int MIN_ARR_SIZE = 1;

    public static void main(String[] args) {
        // STRING LITERALS:
        String howManyElementsPrompt = "How many elements in list: ";
        String notAnIntErrMsg = "Not an integer! Try Again! ";

        // DECLARATIONS
        Scanner user = new Scanner(System.in);
        int[] arr;
        int arraySize;
        int option;

        //TESTING: DRIVER PROGRAM 1, USER (RANDOM) GENERATED
        arraySize = getInt(user, howManyElementsPrompt, notAnIntErrMsg);
        arr = initRand(arraySize, MAX_ARR_SIZE, MIN_ARR_SIZE);

        System.out.println("The list is: ");
        print(arr);
        boolean testingNotComplete = true;
        while (testingNotComplete) {
            option = menu(user, notAnIntErrMsg);
            switch (option) {
                case 0:    //exit program
                    System.out.println("Testing completed.");
                    testingNotComplete = false;
                    break;
                case 1:    //all even
                    if (isAllEven(arr))
                        System.out.println("All values/list are even");
                    else
                        System.out.println("Some values/list are odd");
                    break;
                case 2:    //all unique
                    if (isUnique(arr, arraySize))
                        System.out.println("All values/list are unique");
                    else
                        System.out.println("Some values/list appear multiple times");
                    break;
                case 3:    //print min gap
                    System.out.printf("The minimum gap between 2 adjacent values is %d", minGap(arr, arraySize));
                    break;
                case 4:    //stats: mean, variance, std dev
                    double variance = getVariance(arr, arraySize);
                    print(arr);
                    System.out.printf("The mean for this list is: %.2f", getMean(arr, arraySize));
                    System.out.printf("\nThe variance for this list is: %.2f", variance);
                    System.out.printf("\nThe standard deviation for this list is: %.2f", sqrt(variance));
                    break;
                case 5:    //print sort, print 80% percentile
                    System.out.println("The list sorted: ");
                    print(bubbleSort(copy(arr, arraySize), arraySize));
                    top_20(arr, arraySize);
                    break;
                default:
                    System.out.println("Not a valid choice!");
                    break;
            }
        }
    }

    /**
     * That returns the variance of a list of integers.
     *
     * @param arr  The array to find the variance of.
     * @param size The size of the array.
     * @return The variance of the list of integers.
     */
    public static double getVariance(int[] arr, int size) {
        double mean = getMean(arr, size);
        double[] sqrOfDevs = new double[size];
        //squares of deviations:
        for (int i = 0; i < size; i++)
            sqrOfDevs[i] = pow(mean - arr[i], 2);
        //getting the mean of new array:
        return getMean(sqrOfDevs, sqrOfDevs.length);
    }

    /**
     * Calculates the mean of an integer array.
     *
     * @param arr  The int array used to calculate mean.
     * @param size The size of the array.
     * @return The average value of the list.
     */
    public static double getMean(int[] arr, int size) {
        if (size == 0) return 0; //to avoid error
        double n = 0;
        for (int i : arr)
            n += i;

        return n / size;
    }

    /**
     * Calculates the mean of a double array.
     *
     * @param arr  The double array used to calculate mean.
     * @param size The size of the array.
     * @return The average value of the list.
     */
    public static double getMean(double[] arr, int size) {
        if (size == 0) return 0; //to avoid error
        double n = 0;
        for (double i : arr)
            n += i;
        return n / size;
    }

    /**
     * Prints the 80th percentile of an integer array.
     *
     * @param arr  An integer array.
     * @param size The size of the array.
     */
    public static void top_20(int[] arr, int size) {
        int n = size / 5;
        int[] temp = copy(arr, size);
        bubbleSort(temp, size);
        System.out.println("80%-percentile from this list: ");
        for (int i = size - n; i < size; i++)
            System.out.printf("%d ", temp[i]);
    }

    /**
     * Value returning method that creates a copy of an array.
     *
     * @param arr  The array to be copied
     * @param size The size of the array.
     * @return A new array which contains the contents of the parameter array.
     */
    public static int[] copy(int[] arr, int size) {
        int[] arrCopy = new int[size];
        for (int i = 0; i < size; i++)
            arrCopy[i] = arr[i];
        return arrCopy;
    }

    /**
     * Sorts an array in ascending order using the bubble sort algorithm.<br>
     * Time complexity: O(n^2)
     *
     * @param arr  The array to be sorted
     * @param size The size of the array.
     * @return A sorted array.
     */
    public static int[] bubbleSort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }

    /**
     * Prints a list of options and returns a valid option.
     *
     * @param userInput      A scanner object for the user's input
     * @param notAnIntErrMsg The error message for invalid input
     * @return An integer that represents a valid option.
     */
    public static int menu(Scanner userInput, String notAnIntErrMsg) {
        String prompt = "Please enter your option: ";
        System.out.print("\n" +
                         "Your options are:\n" +
                         "-----------------\n" +
                         "   1) All even values?\n" +
                         "   2) All unique values?\n" +
                         "   3) Print min gap between values\n" +
                         "   4) Statistics\n" +
                         "   5) Print 80% percentile\n" +
                         "   0) EXIT\n");
        return getInt(userInput, prompt, notAnIntErrMsg);
    }

    /**
     * Calculates the minimum 'gap' between adjacent values in the array.<br>
     * The gap between two adjacent values in an array is defined as the second value minus the first value.
     *
     * @param arr  The integer array.
     * @param size The size of the array.
     * @return The minimum gap between adjacent values in the array.
     */
    public static int minGap(int[] arr, int size) {
        if (size <= 0) return 0;
        int temp;
        int lowest = arr[1] - arr[0];
        for (int i = 0; i < size - 1; i++) {
            temp = arr[i + 1] - arr[i];
            if (temp < lowest)
                lowest = temp;
        }
        return lowest;
    }

    /**
     * Determines whether all elements of an integer array are different.
     *
     * @param arr  An integer array.
     * @param size The size of the array.
     * @return True if all elements of the array are unique.
     */
    public static boolean isUnique(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++)
                if (arr[i] == arr[j])
                    return false;

        return true;
    }

    /**
     * Determines whether an integer array has all even value
     *
     * @param arr An integer array.
     * @return True if all elements of the array are even.
     */
    public static boolean isAllEven(int[] arr) {
        for (int j : arr) {
            if (j % 2 == 1)
                return false;
        }
        return true;
    }

    /**
     * Prints all the elements of an array.
     *
     * @param arr The array to be printed.
     */
    public static void print(int[] arr) {
        for (int n : arr) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }

    /**
     * Initializes an array with random numbers with bounds.
     *
     * @param numOfElements Number of elements in the array
     * @param max           The maximum bound of the random number generation.
     * @param min           The minimum bound of the random number generation.
     * @return A one dimensional array filled with random numbers.
     */
    public static int[] initRand(int numOfElements, int max, int min) {
        if (numOfElements <= 0)
            return new int[]{};
        Random r = new Random();
        int[] arr = new int[numOfElements];
        for (int i = 0; i < numOfElements; i++)
            arr[i] = r.nextInt(((max - min) + 1) + min);
        return arr;
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
}