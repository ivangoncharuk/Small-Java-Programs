package cosc237.assignments.number1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Ivan Goncharuk
 * @author Ryan Fitzpatrick
 * @author Million Abiyoto
 */
public class ModularityFile extends Modularity
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String fileName;

        System.out.print("Enter the file name to read: ");
        // only files in the same directory as the program are allowed
        fileName = "src/cosc237/assignments/number1/files/" + input.next().trim();

        try
        {
            File sourceFile = new File(fileName);
            Scanner inputFile = new Scanner(sourceFile);
            Scanner readFile = new Scanner(sourceFile);

            int numIntegers = 0;

            // Establish number of integers in file to find array size
            while (readFile.hasNext())
            {
                if (readFile.hasNextInt())
                {
                    readFile.nextInt();
                    numIntegers++;
                } else
                    readFile.next(); // Consume unwanted input
            }

            // Ensure file has values
            if (numIntegers < 1)
            {
                System.out.println("File has no values. System exiting.");
                System.exit(0);
            }

            // Populate new array with these integers
            int[] array = new int[numIntegers];
            int i = 0;
            while (inputFile.hasNext())
            {
                if (inputFile.hasNextInt())
                {
                    array[i] = inputFile.nextInt();
                    i++;
                } else
                    inputFile.next(); // Consume unwanted input
            }

            while (true)
            {
                printMenu();
                int choice = getInt(input);
                System.out.println("The original array is: ");
                printArray(array);
                if (menuOptions(choice, array, input))
                    return;
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
    }
}
