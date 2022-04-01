package cosc237.assignments.number3.linked;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;

public class ClientMerge_1 {
    static Scanner input = new Scanner(System.in);
    static final String notAnIntMsg = "Not a valid integer!\n";

    public static void main(String[] args)
    {
        UnorderedLinkedListInt list1 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt list2 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt list3 = new UnorderedLinkedListInt();
        int num;
        out.println("Enter integers for the first list(999 to stop)");
        num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        while (num != 999) {
            list1.insertLast(num);
            num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        }
        out.println("Enter integers for the second list(999 to stop)");
        num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        while (num != 999) {
            list2.insertLast(num);
            num = getInput(input, "", notAnIntMsg, Integer::parseInt);
        }
        out.print("\nThe first list is: ");
        list1.print();
        out.println("\nThe length of the first list is: " + list1.length());
        if (!list1.isEmptyList()) {
            out.println("First element/list1: " + list1.front());
            out.println("Last element/list1: " + list1.back());
        }
        out.print("\nThe second list is: ");
        list2.print();
        out.println("\nThe length of the second list is: " + list2.length());
        if (!list2.isEmptyList()) {
            out.println("First element/list2: " + list2.front());
            out.println("Last element/list2: " + list2.back());
        }
        list1.merge1(list2);
        out.print("\nAfter concatenating the 2 lists, the merged list1 is: ");
        list1.print();
        out.println("\nThe length of the merged list is: " + list1.length());
        if (!list3.isEmptyList()) {
            out.println("First element/merged list: " + list1.front());
            out.println("Last element/merged list: " + list1.back());
        }
        out.println("Enter key for split: ");
        num = getInput(input, "", notAnIntMsg, Integer::parseInt);

        UnorderedLinkedListInt split1 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt split2 = new UnorderedLinkedListInt();
        list1.split(split1, split2, num);
        out.print("\nThe first list after split is: ");
        split1.print();
        out.print("\nThe second list after split is: ");
        split2.print();
        out.println();
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
