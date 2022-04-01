package cosc237.lab9;

//Testing the method removeDuplicates using the Java ArrayList class

import java.util.ArrayList;

public class Lab9_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(9);
        list.add(9);
        System.out.println("The original list is: ");
        print(list);
        System.out.println("The list after method call is: ");
        removeDuplicates(list);
        print(list);
    }

    public static void removeDuplicates(ArrayList<Integer> list) {
        //add your code here
        //2 2 2 5 5 8 9 9
        ArrayList<Integer> temp   = new ArrayList<>();
        int                length = list.size();
        int                tempLength;
        for (int i = 0; i < length - 1; i++)
            if (!list.get(i).equals(list.get(i + 1))) {
                System.out.println("i != i+1, list[i] = " + list.get(i));
                temp.add(list.get(i));
            }
        temp.add(list.get(length - 1));
        list.clear();
        tempLength = temp.size();
        for (int i = 0; i < tempLength; i++)
             list.add(temp.get(i));
    }
    public static void print(ArrayList<Integer> someList) {
        for (Integer i : someList)
            System.out.print(i + "  ");
        System.out.println();
    }
}
/*OUTPUT:
The original list is:
2  2  2  5  5  8  9  9
The list after method call is:
2  5  8  9
*/
