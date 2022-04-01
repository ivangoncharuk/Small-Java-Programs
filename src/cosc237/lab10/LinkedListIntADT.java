package cosc237.lab10;

//Interface: LinkedListIntADT
public interface LinkedListIntADT {
    boolean isEmptyList();         //Method to determine whether the list is empty.
    void initializeList();         //Method to initialize the list to an empty state.
    void print();                  //Method to output the data contained in each node.
    int length();                  //Method to return the number of nodes in the list.
    int front();                     //Method to return a reference to the first node
    int back();                      //Method to return a reference to the first node
    boolean search(int searchItem);  //Method to determine whether searchItem is in the list.
    void insertFirst(int newItem);   //Method to insert newItem in the list.
    void insertLast(int newItem);    //Method to insert newItem at the end of the list.
    void deleteNode(int deleteItem); //Method to delete deleteItem from the list.
}
