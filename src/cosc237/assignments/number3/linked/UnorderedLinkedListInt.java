package cosc237.assignments.number3.linked;

//Class: UnorderedLinkedListInt extends
//Class: LinkedListIntClass
public class UnorderedLinkedListInt extends LinkedListIntClass {
    //Default constructor
    public UnorderedLinkedListInt() {
        super();
    }

    /**
     * This method will append list1 to the original list. Side effect: the original list is lost.
     *
     * @param list1 the list being merged with this list
     */
    public void merge1(UnorderedLinkedListInt list1) {
        if (list1.first == null) {
            System.err.println("Cannot merge with an empty list.");
        } else {
            LinkedListNode current = list1.first;
            while (current != null) {
                insertLast(current.info);
                current = current.link;
            }
        }
    }

    /**
     * This method should create a new list with the concatenation result. The original lists should be preserved
     *
     * @param list1 the list being merged with this list
     * @return a new merged UnorderedLinkedListInt list
     */
    public UnorderedLinkedListInt merge2(UnorderedLinkedListInt list1) {
        UnorderedLinkedListInt result = new UnorderedLinkedListInt();

        if (first == null && list1.first == null) {
            System.err.println("Cannot merge two empty lists.");
        } else {
            LinkedListNode current1 = first;
            while (current1 != null) {
                result.insertLast(current1.info);
                current1 = current1.link;
            }
            LinkedListNode current2 = list1.first;
            while (current2 != null) {
                result.insertLast(current2.info);
                current2 = current2.link;
            }
        }
        return result;
    }

    /**
     * This method should split the original list into list1 and list2. The original list should be preserved.
     *
     * @param list1 The first list
     * @param list2 The second list
     * @param key   The key used to split the list. First list will be <= the value of key The second list will be the
     *              rest of the values.
     */
    public void split(UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, int key) {
        LinkedListNode current = first;
        while (current != null) {
            if (current.info <= key) {
                list1.insertLast(current.info);
            } else {
                list2.insertLast(current.info);
            }
            current = current.link;
        }
    }

    public boolean search(int searchItem) {
        LinkedListNode current; //variable to traverse the list
        current = first;
        while (current != null)
            if (current.info == searchItem)
                return true;
            else
                current = current.link;
        return false;
    }

    public void insertFirst(int newItem) {
        LinkedListNode newNode;  //variable to create the new node
        //create and insert newNode before first
        newNode = new LinkedListNode(newItem, first);
        first = newNode;
        if (last == null)
            last = newNode;
        count++;
    }

    public void insertLast(int newItem) {
        LinkedListNode newNode; //variable to create the new node
        //create newNode
        newNode = new LinkedListNode(newItem, null);
        if (first == null) {
            first = newNode;
        } else {
            last.link = newNode;
        }
        last = newNode;
        count++;
    }

    public void deleteNode(int deleteItem) {
        LinkedListNode current; //variable to traverse the list
        LinkedListNode trailCurrent; //variable just before current
        boolean found;
        //Case 1; the list is empty
        if (first == null)
            System.err.println("Cannot delete from an empty list.");
        else {
            //Case 2: the node to be deleted is first
            if (first.info == deleteItem) {
                first = first.link;
                if (first == null)  //the list had only one node
                    last = null;
                count--;
            } else {  //search the list for the given info
                found = false;
                trailCurrent = first; //trailCurrent points to first node
                current = first.link; //current points to second node
                while (current != null && !found) {
                    if (current.info == deleteItem)
                        found = true;
                    else {
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                //Case 3; if found, delete the node
                if (found) {
                    count--;
                    trailCurrent.link = current.link;
                    if (last == current)  //node to be deleted was the last node
                        last = trailCurrent;
                } else
                    System.out.println("Item to be deleted is not in the list.");
            }
        }
    }
}

