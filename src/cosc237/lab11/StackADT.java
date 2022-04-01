package cosc237.lab11;

//Interface: StackADT
public interface StackADT<T> {
    void initializeStack();//Method to initialize the stack to an empty state.
    boolean isEmptyStack();//Method to determine whether the stack is empty.
    boolean isFullStack(); //Method to determine whether the stack is full.
    T peek();              //Method to return the top element of the stack.
    void push(T newItem);  //Method to add newItem to the stack.
    void pop();            //Method to remove the top element of the stack.
}
