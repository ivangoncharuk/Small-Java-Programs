package cosc237.assignments.number3.arraylist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;

public class ArrayListProblem4
{
/*
    Please input the name of the file to be opened for first list: list1.txt
    Please input the name of the file to be opened for second list: list2.txt
    The first list is: [13, 25, 34, 67, 56, 10, 20, 27, 2, 5, 1, 45, 59]
    The second list is: [73, 29, 14, 87, 72, 100, 200, 127, 22, 15, 19, 145, 159, 78]
    The merged list is: [13, 25, 34, 67, 56, 10, 20, 27, 2, 5, 1, 45, 59, 73, 29, 14, 87, 72,
    100, 200, 127, 22, 15, 19, 145, 159, 78]
    The merged list sorted is: [1, 2, 5, 10, 13, 14, 15, 19, 20, 22, 25, 27, 29, 34, 45, 56,
    59, 67, 72, 73, 78, 87, 100, 127, 145, 159, 200]
    Enter key for split: 33
    The first list after split is: [1, 2, 5, 10, 13, 14, 15, 19, 20, 22, 25, 27, 29]
    The second list after split is: [34, 45, 56, 59, 67, 72, 73, 78, 87, 100, 127, 145, 159, 200]
*/

    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);

        out.println("Please input the name of the file to be opened for first list: ");
        String fileName1 = "src/assignment.number3.arraylist.files/" + user.next().trim();
        out.println("Please input the name of the file to be opened for second list: ");
        String fileName2 = "src/assignment.number3.arraylist.files/" + user.next().trim();
        try {
            File f1 = new File(fileName1);
            File f2 = new File(fileName2);
            Scanner sf1 = new Scanner(f1);
            Scanner sf2 = new Scanner(f2);
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> mergedList;
            ArrayList<ArrayList<Integer>> splitLists;
            int key;

            //populate lists
            while (sf1.hasNext())
                if (sf1.hasNextInt())
                    list1.add(sf1.nextInt());
                else
                    sf1.next();
            while (sf2.hasNext())
                if (sf2.hasNextInt())
                    list2.add(sf2.nextInt());
                else
                    sf2.next();

            out.println("The first list is:");
            out.println(Arrays.toString(list1.toArray()));
            out.println("The second list is:");
            out.println(Arrays.toString(list2.toArray()));
            out.println("The merged list is:");
            mergedList = merge(list1, list2);
            out.println(Arrays.toString(mergedList.toArray()));

            key = getInput(user, "Enter key for split: ", "Not an integer!\n", Integer::parseInt);
            splitLists = split(mergedList, key);
            out.println("The first list after split is:");
            out.println(Arrays.toString(splitLists.get(0).toArray()));
            out.println("The second list after split is:");
            out.println(Arrays.toString(splitLists.get(1).toArray()));

        } catch (FileNotFoundException e) {
            out.println("File not found.");
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

    private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        int list1Size = list1.size();
        int list2Size = list2.size();
        ArrayList<Integer> mergedList = new ArrayList<>(list1Size + list2Size);

        mergedList.addAll(list1);
        mergedList.addAll(list2);

        return mergedList;
    }

    private static ArrayList<ArrayList<Integer>> split(ArrayList<Integer> list, int key)
    {
        ArrayList<Integer> split1 = new ArrayList<>();
        ArrayList<Integer> split2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = list.size();
        for (int n : list) {
            if (n <= key) {
                split1.add(n);
            }
            else {
                split2.add(n);
            }
        }
        result.add(split1);
        result.add(split2);
        return result;
    }
}
