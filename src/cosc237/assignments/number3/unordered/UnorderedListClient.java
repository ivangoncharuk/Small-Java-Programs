package cosc237.assignments.number3.unordered;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;

public class UnorderedListClient
{
    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);

        out.println("Please input the name of the file to be opened for first list: ");
        String fileName1 = "src/files/" + user.next().trim();
        out.println("Please input the name of the file to be opened for second list: ");
        String fileName2 = "src/files/" + user.next().trim();
        try {
            File f1 = new File(fileName1);
            File f2 = new File(fileName2);
            Scanner sf1 = new Scanner(f1);
            Scanner sf2 = new Scanner(f2);
            int numOfInts1 = findNumOfInts(new Scanner(f1));
            int numOfInts2 = findNumOfInts(new Scanner(f2));
            // Ensure file has values
            if (numOfInts1 < 1) {
                out.println("First file has no values. System exiting.");
                System.exit(0);
            }
            else if (numOfInts2 < 1) {
                out.println("Second file has no values. System exiting.");
                System.exit(0);
            }

            UnorderedArrayList list1 = new UnorderedArrayList(numOfInts1);
            UnorderedArrayList list2 = new UnorderedArrayList(numOfInts2);
            populate(sf1, list1);
            populate(sf2, list2);


            out.println("The first list is:");
            list1.print();
            out.println("The second list is:");
            list2.print();
            out.println("The merged list is:");
            UnorderedArrayList mergedList = list1.merge(list2);
            mergedList.print();

            UnorderedArrayList split1 = new UnorderedArrayList();
            UnorderedArrayList split2 = new UnorderedArrayList();
            out.println("Enter key for split: ");
            int key = getInput(user, "", "Not an integer!\n", Integer::parseInt);
            mergedList.split(split1, split2, key);
            out.println("The first list after split is:");
            split1.print();

            out.println("The second list after split is:");
            split2.print();

        } catch (FileNotFoundException e) {
            out.println("File not found.");
            System.exit(0);
        }
    }

    private static <T> T getInput(Scanner scan, String prompt, String errMsg, Function<String, T> parse)
    {
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

    // Establish number of integers in file to find array size
    private static int findNumOfInts(Scanner file)
    {
        int numIntegers = 0;
        while (file.hasNext())
            if (file.hasNextInt()) {
                file.nextInt();
                numIntegers++;
            }
            else
                file.next();
        return numIntegers;
    }

    //populate list with file Scanner obj
    private static void populate(Scanner file, UnorderedArrayList list)
    {
        while (file.hasNext()) {
            if (file.hasNextInt())
                list.insertEnd(file.nextInt());
            else
                file.next();
        }
    }
}
