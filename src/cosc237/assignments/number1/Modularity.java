package cosc237.assignments.number1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Ivan Goncharuk
 * @author Ryan Fitzpatrick
 * @author Million Abiyoto
 */
@SuppressWarnings("TextBlockMigration")
public class Modularity
{

    protected static final int arrayValueMin = 1;
    protected static final int arrayValueMax = 100;

    protected static final int arraySizeMin = 2;
    protected static final int arraySizeMax = 20;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            printMenu();
            int choice = getInt(input);
            int[] array;
            array = choice != 0 ? createArray(input, arraySizeMin, arraySizeMax) : null;
            if (array != null)
            {
                System.out.println("The original list is: ");
                printArray(array);
            }
            if (menuOptions(choice, array, input))
                return;
        }
    }

    protected static boolean menuOptions(int choice, int[] array, Scanner input)
    {
        switch (choice)
        {
            case 0:
                System.out.println("Testing complete. Exit program.");
                return true;
            case 1:
                shiftLeft(array);
                System.out.println("The list after left rotation is: ");
                printArray(array);
                break;
            case 2:
                System.out.print("Input k (step for shift left): ");
                int k = getInt(input);
                shiftLeft(array, k);
                System.out.println("The original list after left rotation with " + k + " positions is: ");
                printArray(array);
                break;
            case 3:
                System.out.print("Input k (step for shift left): ");
                int k2 = getInt(input);
                System.out.println("The second list after left rotation with " + k2 + " positions is: ");
                printArray(shiftLeftK(array, k2));
                break;
            case 4:
                shiftRight(array);
                System.out.println("The list after right rotation is: ");
                printArray(array);
                break;
            case 5:
                System.out.print("Input k (step for shift right): ");
                int k3 = getInt(input);
                shiftRight(array, k3);
                System.out.println("The original list after right rotation with " + k3 + " positions is: ");
                printArray(array);
                break;
            case 6:
                System.out.print("Input k (step for shift right): ");
                int k4 = getInt(input);
                System.out.println("The second list after right rotation with " + k4 + " positions is: ");
                printArray(shiftRightK(array, k4));
                break;
            default:
                System.out.print("Not a choice. Try again: ");
                break;
        }
        System.out.println();
        return false;
    }

    /**
     * Prints the menu.
     */
    protected static void printMenu()
    {
        System.out.println("Your options are:"
                           + "\n-----------------\n"
                           + "1) Shift left\n"
                           + "2) Shift left (k steps)/in place\n"
                           + "3) Shift left (k steps)/second array\n"
                           + "4) Shift right\n"
                           + "5) Shift right (k steps)/in place\n"
                           + "6) Shift right (k steps)/second array\n"
                           + "0) EXIT");

    }

    // Retrieves a valid integer from the user, repeating retrieving input until an integer is entered
    protected static int getInt(Scanner input)
    {
        while (!input.hasNextInt())
        {
            System.out.print("Not an integer! Try again: ");
            input.next();
        }
        return input.nextInt();
    }

    protected static int[] createArray(Scanner input, int arraySizeMin, int arraySizeMax)
    {
        System.out.print("How many elements in this list: ");
        int arraySize = getInt(input);
        while (arraySize >= arraySizeMax || arraySize <= arraySizeMin)
        {
            System.out.printf("Array size must be greater than %d and less than %d. Try again: ",
                    arraySizeMin, arraySizeMax);
            arraySize = getInt(input);
        }
        int[] array = new int[arraySize];
        initRand(array, arrayValueMin, arrayValueMax);
        return array;
    }

    protected static void printArray(int[] array)
    {
        for (int j : array)
        {
            System.out.printf("%5d", j);
        }
        System.out.println();
    }

    // Shifts the array left 1 index
    protected static void shiftLeft(int[] arr)
    {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int newIndex = (i + (arr.length - 1)) % arr.length;
            temp[newIndex] = arr[i];
        }
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = temp[i];
        }
    }

    protected static void shiftLeft(int[] arr, int k)
    {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int newIndex = (i + (arr.length - k)) % arr.length;
            temp[newIndex] = arr[i];
        }
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = temp[i];
        }
    }

    protected static int[] shiftLeftK(int[] arr, int k)
    {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int newIndex = (i + (arr.length - k)) % arr.length;
            temp[newIndex] = arr[i];
        }
        return temp;
    }

    protected static void shiftRight(int[] arr)
    {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int newIndex = (i + (arr.length + 1)) % arr.length;
            temp[newIndex] = arr[i];
        }
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = temp[i];
        }
    }

    protected static void shiftRight(int[] arr, int k)
    {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int newIndex = (i + (arr.length + k)) % arr.length;
            temp[newIndex] = arr[i];
        }
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = temp[i];
        }
    }

    protected static int[] shiftRightK(int[] arr, int k)
    {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int newIndex = (i + (arr.length + k)) % arr.length;
            temp[newIndex] = arr[i];
        }
        return temp;
    }

    // Fills the array with random numbers between valueMin and valueMax, inclusive
    protected static void initRand(int[] array, int valueMin, int valueMax)
    {
        Random r = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = valueMin + r.nextInt((valueMax + 1) - valueMin);
        }
    }
}