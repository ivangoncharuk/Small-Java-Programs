package cosc237.lab11;


import java.util.Scanner;
import java.util.function.Function;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String error = "Not an integer!\n";
        LinkedStackClass<Integer> stack = new LinkedStackClass<>();
        QueueClass<Integer> queue = new QueueClass<>();
        System.out.print("Enter integers (999 to stop): ");
        Integer n = getInput(scanner, "", Integer::parseInt);
        while (n != 999) {
            stack.push(n);
            n = getInput(scanner, "", Integer::parseInt);
        }

        System.out.println("The original stack printed in direct order (bottom to top) is: ");
        printStack(stack);
        System.out.println("The stack printed in reverse order (top to bottom) is: ");
        printBackStack(stack);

        System.out.printf("The stack stores %d items.\n", countItems(stack));
        System.out.printf("The top is: %d\n", !stack.isEmptyStack() ? stack.peek() : 0);
        System.out.printf("The second item (below top) is: %d\n", getSecond(stack));
        System.out.println("Enter value to be removed from stack:");

        int removeItem = getInput(scanner, error, Integer::parseInt);

        removeItem(stack, removeItem);
        System.out.printf("The stack after removing every occurrence of %d is:\n", removeItem);
        printStack(stack);

        reverseStack(stack);
        System.out.println("Program has reversed the stack. The new stack printed in direct order is:");
        printStack(stack);

        _reverseStack(stack);
        System.out.println("Program has reversed the stack again using _reverseStack()," +
                           "The new stack printed in direct order is:");
        printStack(stack);

        System.out.print("Enter integers (999 to stop): ");
        n = getInput(scanner, "", Integer::parseInt);
        while (n != 999) {
            queue.enqueue(n);
            n = getInput(scanner, "", Integer::parseInt);
        }

        System.out.println("The queue is:");
        printQueue(queue);
        System.out.println("The reversed queue is:");
        reverseQueue(queue);
        printQueue(queue);

        System.out.println("The queue reversed again with _reverseQueue() is");
        _reverseQueue(queue);
        printQueue(queue);
    }

    /**
     * Gets the desired input from a scanner.
     *
     * @param scan   A scanner object
     * @param errMsg Error message that appears when the scanner scans an undesired input
     * @param parse  The function used to parse a string to the desired input type
     * @param <T>    Generic return that depends on the parse function
     * @return The desired input type that comes from parsing a string from a scanner
     */
    private static <T> T getInput(Scanner scan, String errMsg, Function<String, T> parse) {
        String str;
        while (true) {
            str = scan.next();
            try {
                return parse.apply(str);
            } catch (Exception e) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Prints the elemts in a stack in reverse order (top to bottom).
     * Leaves the original stack unchanged.
     *
     * @param intStack The original stack
     */
    public static void printBackStack(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack()) {
            System.out.println();
            return;
        }
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        while (!(intStack.isEmptyStack())) {
            System.out.print(intStack.peek() + " ");
            temp.push(intStack.peek());
            intStack.pop();
        }
        System.out.println();
        while (!(temp.isEmptyStack())) {
            intStack.push(temp.peek());
            temp.pop();
        }
    }

    /**
     * Prints the elements in a stack in direct order (bottom to top).
     * Leaves the original stack unchanged.
     *
     * @param intStack The original stack
     */
    public static void printStack(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack()) {
            System.out.println();
            return;
        }
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        while (!(intStack.isEmptyStack())) {
            temp.push(intStack.peek());
            intStack.pop();
        }
        while (!(temp.isEmptyStack())) {
            System.out.print(temp.peek() + " ");
            intStack.push(temp.peek());
            temp.pop();
        }
        System.out.println();
    }

    /**
     * Gets the second element of the stack. Returns 0 if the stack is empty or if the
     * second element does not exist.
     * Leaves the original stack unchanged.
     *
     * @param intStack The original stack.
     * @return The second element of the stack.
     */
    public static Integer getSecond(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack())
            return 0;
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        Integer result = 0;
        int count = 0;
        while (!(intStack.isEmptyStack())) {
            temp.push(intStack.peek());
            result = ++count == 2 ? temp.peek() : result;
            intStack.pop();
        }
        while (!(temp.isEmptyStack())) {
            intStack.push(temp.peek());
            temp.pop();
        }
        return result;
    }

    /**
     * Counts the number of items in the stack. Leave the original stack unchanged.
     *
     * @param intStack The original stack.
     * @return The number of items in the stack
     */
    public static int countItems(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack())
            return 0;
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        int result = 0;
        while (!(intStack.isEmptyStack())) {
            temp.push(intStack.peek());
            intStack.pop();
            result++;
        }
        while (!(temp.isEmptyStack())) {
            intStack.push(temp.peek());
            temp.pop();
        }
        return result;
    }

    /**
     * Removes an item from the stack, leaving the order of the original stack unchanged.
     *
     * @param intStack The original stack
     * @param n        The item to be removed
     */
    public static void removeItem(LinkedStackClass<Integer> intStack, Integer n) {
        if (intStack.isEmptyStack())
            return;
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        while (!(intStack.isEmptyStack())) {
            if (!(intStack.peek().equals(n)))
                temp.push(intStack.peek());
            intStack.pop();
        }
        while (!(temp.isEmptyStack())) {
            intStack.push(temp.peek());
            temp.pop();
        }
    }

    /**
     * Reverses a stack using a queue.
     *
     * @param intStack The original stack
     */
    public static void reverseStack(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack())
            return;
        QueueClass<Integer> q = new QueueClass<>();
        while (!(intStack.isEmptyStack())) {
            q.enqueue(intStack.peek());
            intStack.pop();
        }
        while (!(q.isEmptyQueue())) {
            intStack.push(q.front());
            q.dequeue();
        }
    }

    /**
     * Reverses the stack without using a queue.
     *
     * @param intStack The original stack
     */
    public static void _reverseStack(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack())
            return;
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        LinkedStackClass<Integer> temp2 = new LinkedStackClass<>();
        //transfering elements to temp (temp is backwards)
        while (!(intStack.isEmptyStack())) {
            temp.push(intStack.peek());
            intStack.pop();
        }
        //transfering elements from temp to temp2 (temp2 is original stack)
        while (!(temp.isEmptyStack())) {
            temp2.push(temp.peek());
            temp.pop();
        }
        //transfering elements from temp2 to intStack (instack is now reversed)
        while (!(temp2.isEmptyStack())) {
            intStack.push(temp2.peek());
            temp2.pop();
        }
    }

    /**
     * Reverses a queue using a stack
     *
     * @param q The original queue
     */
    public static void reverseQueue(QueueClass<Integer> q) {
        if (q.isEmptyQueue())
            return;
        LinkedStackClass<Integer> s = new LinkedStackClass<>();
        while (!(q.isEmptyQueue())) {
            s.push(q.front());
            q.dequeue();
        }
        while (!(s.isEmptyStack())) {
            q.enqueue(s.peek());
            s.pop();
        }
    }

    /**
     * Reverses a queue without using a stack.<br>
     * This implementation's time complexity: is O(n^2)
     *
     * @param q The original queue
     */
    public static void _reverseQueue(QueueClass<Integer> q) {
        if (q.isEmptyQueue()) {
            System.out.println();
            return;
        }
        QueueClass<Integer> temp_a = new QueueClass<>();
        QueueClass<Integer> temp_b = new QueueClass<>();
        int ctr = 0;
        //counting elements
        while (!(q.isEmptyQueue())) {
            temp_a.enqueue(q.front());
            q.dequeue();
            ctr++; //counting num of elements
        }
        for (int i = 0; i < ctr; i++) {
            switch (i % 2) {
                case 0:
                    //queue the back element
                    temp_b.enqueue(temp_a.back());
                    //queue up the rest of the elements until back()
                    for (int j = 0; j < ctr - 1; j++) {
                        temp_b.enqueue(temp_a.front());
                        temp_a.dequeue();
                    }
                    //save the back element in original queue
                    q.enqueue(temp_b.front());
                    //make the temp queue empty
                    temp_a.dequeue();
                    break;
                case 1:
                    temp_a.enqueue(temp_b.back());
                    for (int j = 0; j < ctr - 1; j++) {
                        temp_a.enqueue(temp_b.front());
                        temp_b.dequeue();
                    }
                    q.enqueue(temp_a.front());
                    temp_b.dequeue();
                    break;
            }
        }
    }

    /**
     * Prints the elements of the queue. Leaves the original queue unchanged.
     *
     * @param q The original queue.
     */
    public static void printQueue(QueueClass<Integer> q) {
        if (q.isEmptyQueue()) {
            System.out.println();
            return;
        }
        QueueClass<Integer> temp = new QueueClass<>();
        while (!(q.isEmptyQueue())) {
            System.out.print(q.front() + " ");
            temp.enqueue(q.front());
            q.dequeue();
        }
        System.out.println();
        while (!(temp.isEmptyQueue())) {
            q.enqueue(temp.front());
            temp.dequeue();
        }
    }
}