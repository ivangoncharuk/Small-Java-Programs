package cosc237.lab9;

import cosc237.lab9.ordered_unordered_lists.OrderedArrayList;

//Testing the method removeDuplicates added to the user created OrderedArrayList class
public class Lab9_3 {
    public static void main(String[] args)  {
        OrderedArrayList list = new OrderedArrayList();
        list.insert(8);
        list.insert(2);
        list.insert(2);
        list.insert(9);
        list.insert(5);
        list.insert(9);
        list.insert(2);
        list.insert(9);
        list.insert(2);
        list.insert(5);
        System.out.println("The original list is: ");
        list.print();
        System.out.println("The list after method call is: ");
        list.removeDuplicates();
        list.print();
    }
}
/*OUTPUT:
The original list is:
2  2  2  2  5  5  8  9  9  9
The list after method call is:
2  5  8  9
*/
