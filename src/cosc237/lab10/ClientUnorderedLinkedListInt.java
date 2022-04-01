package cosc237.lab10;

import java.util.*;
import java.util.function.Function;

import static java.lang.System.out;

public class ClientUnorderedLinkedListInt {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        final String err = "Not a valid integer! Enter again: ";
        UnorderedLinkedListInt intList = new UnorderedLinkedListInt();
        UnorderedLinkedListInt tempList;
        int num;
        out.println("Enter integers (999 to stop)");
        num = getInput(input, err, Integer::parseInt);
        while (num != 999) {
            intList.insertLast(num);
            num = getInput(input, err, Integer::parseInt);
        }
        System.out.print("\nTesting .insertLast and .print. The original list is: ");
        intList.print();
        System.out.println("\nTesting .length. The length of the list is: " + intList.length());
        if (!intList.isEmptyList()) {
            System.out.println("Testing .front. First element/list: " + intList.front());
            System.out.println("Testing .back. Last element/list: "  + intList.back());
        }
        System.out.println("Testing .sum. The sum of data in all nodes is: " + intList.findSum());
        System.out.println("Testing .min. The smallest data in all nodes is: " + intList.findMin());
        System.out.print("Testing .search. Enter the number to search for/list: ");
        num = getInput(input, err, Integer::parseInt);
        if (intList.search(num))
            System.out.println(num + " found in this list.");
        else
            System.out.println(num + " is not in this list.");
        System.out.print("Testing .deleteNode. Enter the number to be deleted from list: ");
        num = input.nextInt();
        intList.deleteNode(num);
        System.out.print("Testing .toString. After deleting " + num + ", the list is: " + intList);
        //intList.print();
        System.out.println("\nThe length of the list after delete is: " + intList.length());
    }

    private static <T> T getInput(Scanner scan, String errMsg, Function<String, T> parse)
    {
        String str;
        while (true) {
            str = scan.next();
            try {
                return parse.apply(str);
            } catch (Exception e) {
                out.print(errMsg);
            }
        }
    }
}
