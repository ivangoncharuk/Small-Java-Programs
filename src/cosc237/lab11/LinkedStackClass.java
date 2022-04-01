package cosc237.lab11;

//Class: LinkedStackClass implements
//Interface: StackADT
//Linked list implementation
public class LinkedStackClass<T> implements StackADT<T> {
    //Node Definition: inner class StackNode
    private static class StackNode<V> {
        public V info;
        public StackNode<V> link;

        //Default constructor
        public StackNode() {
            info = null;
            link = null;
        }

        //Alternate constructor
        public StackNode(V value, StackNode<V> ptr)  {
            info = value;
            link = ptr;
        }

        public String toString() {
            return info.toString();
        }
    }

    //Instance variable for class LinkedStackClass
    private StackNode<T> stackTop; //reference variable to top

    //Default constructor
    public LinkedStackClass() {
        stackTop = null;
    }

    public void initializeStack() {
        stackTop = null;
    }

    public boolean isEmptyStack() {
        return (stackTop == null);
    }

    public boolean isFullStack() {
        return false;
    }

    public T peek() {
        if (stackTop == null){
            System.err.println("No top - the stack is empty!");
            return stackTop.info;
        }
        else
            return stackTop.info;
    }

    public void push(T newValue)  {
        StackNode<T> newNode; //reference variable to create the new node
        newNode = new StackNode<>(newValue, stackTop);
        stackTop = newNode;
    }

    public void pop() {
        if (stackTop == null)
            System.err.println("Cannot pop from an empty stack!");
        else
            stackTop = stackTop.link;
    }
}
