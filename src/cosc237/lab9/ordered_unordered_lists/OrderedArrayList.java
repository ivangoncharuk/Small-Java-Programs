package cosc237.lab9.ordered_unordered_lists;

//Class: OrderedArrayList extends
//Class: ArrayListClass
public class OrderedArrayList extends ArrayListClass {
    //Default constructor
    public OrderedArrayList() {
        super();
    }

    //Alternate constructor
    public OrderedArrayList(int size) {
        super(size);
    }


    //implementation for abstract methods defined in ArrayListClass

    public void insert(int item) {
        int     loc;
        boolean found = false;
        if (length == 0)            //list is empty
            list[length++] = item;  //insert item and increment length
        else if (length == maxSize) //list is full
            System.err.println("Cannot insert in a full list.");
        else {
            for (loc = 0; loc < length; loc++) {
                if (list[loc] >= item) {
                    found = true;
                    break;
                }
            }
            //starting at the end, shift right
            for (int i = length; i > loc; i--)
                 list[i] = list[i - 1];
            list[loc] = item;
            length++;
        }
    }

    public void insertAt(int location, int item) {
        if (location < 0 || location >= maxSize)
            System.err.println("The position of the item to be inserted is out of range.");
        else if (length == maxSize)  //list is full
            System.err.println("Cannot insert in a full list.");
        else {
            System.out.println("This is a sorted list. Doing insert in place (call to insert).");
            insert(item);
        }
    }

    /* Another version for insert:
    public void insert(int item) {
        int loc;
        boolean found = false;
        if (length == 0)            //list is empty
            list[length++] = item;  //insert item and increment length
        else if (length == maxSize) //list is full
            System.err.println("Cannot insert in a full list.");
        else {
            int i = length - 1;
            while (i >= 0 && list[i] > item) {
                list[i + 1] = list[i];
                i--;
            }
            list[i + 1] = item;  // Insert item
            length++;
       }
    } */

    public void insertEnd(int item) {
        if (length == maxSize)  //the list is full
            System.err.println("Cannot insert in a full list.");
        else {
            System.out.println("This is a sorted list. Doing insert in place (call to insert).");
            insert(item);
        }
    }

    public void replaceAt(int location, int item) {
        //the list is sorted!
        //is actually removing the element at location and inserting item in place
        if (location < 0 || location >= length)
            System.err.println("The position of the item to be replaced is out of range.");
        else {
            removeAt(location);//method in ArrayListClass
            insert(item);
        }
    }

    //ordered list --> binary search
    public int search(int item) {
        int first  = 0;
        int last   = length - 1;
        int middle = -1;

        while (first <= last) {
            middle = (first + last) / 2;
            if (list[middle] == item)
                return middle;
            else if (list[middle] > item)
                last = middle - 1;
            else
                first = middle + 1;
        }
        return -1;
    }

    public void remove(int item) {
        int loc;
        if (length == 0)
            System.err.println("Cannot delete from an empty list.");
        else {
            loc = search(item);
            if (loc != -1)
                removeAt(loc);//method in ArrayListClass
            else
                System.out.println("The item to be deleted is not in the list.");
        }
    }

    /*Another version for remove:
    public void remove(T item) {
        int loc;
        if (length == 0)
            System.err.println("Cannot delete from an empty list.");
        else  {
            loc = search(item);
            if (loc != -1) {
                for(int i = loc; i < length - 1; i++)
                    list[i] = list[i + 1]; //shift left
                length--;
            }
            else
                System.out.println("The item to be deleted is not in the list.");
        }
    } */

    public void removeDuplicates() {
        int[] temp;
        int   numOfUnique = 0;
        //Finding number of unique elements.
        for (int i = 0; i < length - 1; i++)
            if (list[i] != list[i + 1])
                list[numOfUnique++] = list[i];

        list[numOfUnique++] = list[length - 1];
        temp                = new int[numOfUnique];
        //initializing temp[]
        for (int i = 0; i < numOfUnique; i++)
             temp[i] = list[i];
        //replacing original list
        list   = temp;
        //replacing original length
        length = numOfUnique;
    }
}
