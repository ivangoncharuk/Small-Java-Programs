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
public class ManyStrings {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "item 1", "item 2", "item3"
        ));
        manyStrings(list, 2);
        System.out.println(list);
    }

    private static void manyStrings(ArrayList<String> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < n - 1; j++) {
                list.add(i, list.get(i));
                i++;
            }
        }
    }
}
