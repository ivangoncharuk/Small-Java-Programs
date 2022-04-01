package cosc237.assignments.number4;


public interface DoubleLinkedListADT<T> {
    void initializeList();
    boolean isEmptyList();
    T front();
    T back();
    int length();
    void print();
    void reversePrint();
    boolean search(T searchItem);
    void insertNode(T insertItem);
    void deleteNode(T deleteItem);
    String toString();
    String recursiveToString();
    String backwardsString();
    String recursiveBackwardsString();
    boolean equals(Object o);
    void copy(DoubleLinkedListClass<T> otherList);
    void reversedCopy(DoubleLinkedListClass<T> otherList);
}
