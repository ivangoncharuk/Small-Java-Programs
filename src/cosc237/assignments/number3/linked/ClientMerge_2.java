package cosc237.assignments.number3.linked;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;

public class ClientMerge_2
{
    //          !=
    static Scanner input = new Scanner(System.in);
    static final String notAnIntMsg = "Not a valid integer!\n";

    public static void main(String[] args)
    {
        UnorderedLinkedListInt list1 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt list2 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt list3 = new UnorderedLinkedListInt();
        int num;
        System.out.println("Enter integers for the first list(999 to stop)");
        num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        while (num != 999) {
            list1.insertLast((Integer) num);
            num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        }
        System.out.println("Enter integers for the second list(999 to stop)");
        num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        while (num != 999) {
            list2.insertLast((Integer) num);
            num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        }
        System.out.print("\nThe first list is: ");
        list1.print();
        System.out.println("\nThe length of the first list is: " + list1.length());
        if (!list1.isEmptyList()) {
            System.out.println("First element/list1: " + list1.front());
            System.out.println("Last element/list1: " + list1.back());
        }
        System.out.print("\nThe second list is: ");
        list2.print();
        System.out.println("\nThe length of the second list is: " + list2.length());
        if (!list2.isEmptyList()) {
            System.out.println("First element/list2: " + list2.front());
            System.out.println("Last element/list2: " + list2.back());
        }
        list3 = list1.merge2(list2);
        System.out.print("\nAfter concatenating the 2 lists, the merged list3 is: ");
        list3.print();
        System.out.println("\nThe length of the merged list is: " + list3.length());
        if (!list3.isEmptyList()) {
            System.out.println("First element/merged list: " + list3.front());
            System.out.println("Last element/merged list: " + list3.back());
        }
        System.out.println("Enter key for split: ");
        num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        UnorderedLinkedListInt split1 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt split2 = new UnorderedLinkedListInt();
        list3.split(split1, split2, num);
        System.out.print("\nThe first list after split is: ");
        split1.print();
        System.out.print("\nThe second list after split is: ");
        split2.print();
        System.out.println();
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
}




/*
SAMPLE OUTPUT:

Enter integers for the first list(999 to stop) 37 10 88 59 27 20 14 32 89 100 12 999
Enter integers for the second list(999 to stop) 23 56 34 15 78 19 999
The first list is: 37 10 88 59 27 20 14 32 89 100 12 The length of the first list is: 11
First element/list1: 37
Last element/list1: 12
The second list is: 23 56 34 15 78 19
The length of the second list is: 6
First element/list2: 23
Last element/list2: 19
After concatenating the 2 lists, the
23 56 34 15 78 19
The length of the merged list is: 17
First element/merged list: 37
Last element/merged list: 19
merged list1 is: 37 10 88 59 27 20 14 32 89 100 12
Enter key for split: 20
The first list after split is: 10 20 14 12 15 19
The second list after split is: 37 88 59 27 32 89 100 23 56 34 78
 */
