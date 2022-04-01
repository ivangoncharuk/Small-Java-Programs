package cosc237.assignments.number4;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedListClass<Integer> list1 = new DoubleLinkedListClass<>();

        for (int i = 0; i <= 30; i+=5) {
            list1.insertNode(i);
        }
        System.out.println(list1);
        list1.print();

        System.out.println(list1.backwardsString());
        list1.reversePrint();

        System.out.println("The front: " + list1.front());
        System.out.println("The back: " + list1.back());

        boolean isNPresent = (list1.search(5));
        System.out.println("is 5 present? " + (isNPresent ? "Yes" : "No"));
        if (isNPresent) {
            System.out.println("deleting 5...");
            list1.deleteNode(5);
            System.out.println("the list now: ");
            System.out.println(list1);
            System.out.println("is 5 present? " + (list1.search(5) ? "Yes" : "No"));
        }

        DoubleLinkedListClass<Integer> list2 = new DoubleLinkedListClass<>();
        System.out.println("New list: " + list2);
        System.out.println("Copying old list to new list...");
        list2.copy(list1);
        System.out.println("New list: " + list2);

        System.out.println("Copying old list to new list but reversed...");
        list2.reversedCopy(list1);
        System.out.println("New list: " + list2);

        System.out.println("Testing recursion methods: ");
        System.out.println(list1.recursiveToString());
        System.out.println(list1.recursiveBackwardsString());
    }
}
