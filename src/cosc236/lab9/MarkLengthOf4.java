package cosc236.lab9;

import java.util.ArrayList;
import java.util.Arrays;
/*
Write a method manyStrings that takes an ArrayList of Strings and an integer n as parameters and that replaces
every String in the original list with n of that String.  For example, suppose that an ArrayList called "list"
contains the following values:
("squid", "octopus")
And you make the following call:
manyStrings(list, 2);
Then list should store the following values after the call:
("squid", "squid", "octopus", "octopus")
As another example, suppose that list contains the following:
("a", "a", "b", "c")
and you make the following call:
manyStrings(list, 3);
Then list should store the following values after the call:
("a", "a", "a", "a", "a", "a", "b", "b", "b", "c", "c", "c")
You may assume that the ArrayList you are passed contains only Strings and that the integer n is greater than 0
 */
public class MarkLengthOf4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"
        ));
        System.out.println(list);
        markLength4(list);
        System.out.println("new list: " + list);

    }

    public static void markLength4(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }
}

