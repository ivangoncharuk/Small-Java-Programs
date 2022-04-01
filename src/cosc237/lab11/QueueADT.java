package cosc237.lab11;

//Interface: QueueADT
public interface QueueADT<T> {
    void initializeQueue(); //Method to initialize the queue to an empty state.
    boolean isEmptyQueue(); //Method to determine whether the queue is empty.
    boolean isFullQueue();  //Method to determine whether the queue is full.
    T front() throws QueueUnderflowException; //Method to return the first element of the queue.
    T back() throws QueueUnderflowException;  //Method to return the last element of the queue.
    void enqueue(T newItem); //Method to add newItem to the queue.
    void dequeue() throws QueueUnderflowException; //Method to remove the first element of the queue.
}



