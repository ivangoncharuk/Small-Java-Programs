package cosc237.assignments.number4;

public class DoubleLinkedListClass<T> implements DoubleLinkedListADT<T> {
    protected DoubleLinkedListNode<T> first; //ref to head
    protected DoubleLinkedListNode<T> last;  //ref to tail
    protected int count;

    public class DoubleLinkedListNode<V> {
        public V info;
        public DoubleLinkedListNode<V> next;
        public DoubleLinkedListNode<V> back;

        //default constructor:
        public DoubleLinkedListNode() {
            info = null;
            next = null;
            back = null;
        }

        public String toString() {
            return info.toString();
        }
    }

    @Override
    public String toString() {
        DoubleLinkedListNode<T> node = first;
        String str = "[head] - ";
        while (node != null) {
            str += node.info + " - ";
            node = node.next;
        }
        str += "[tail]";
        return str;
    }

    @Override
    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

    @Override
    public boolean isEmptyList() {
        return first == null;
    }

    @Override
    public T front() {
        return first.info;
    }

    @Override
    public T back() {
        return last.info;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public void print() {
        DoubleLinkedListNode<T> node = first;
        while (node != null) {
            System.out.print(node.info);
            node = node.next;
            System.out.print(node != null ? ", " : "\n");
        }
    }

    @Override
    public void reversePrint() {
        DoubleLinkedListNode<T> node = last;
        while (node != null) {
            System.out.print(node.info);
            node = node.back;
            System.out.print(node != null ? ", " : "\n");
        }
    }

    @Override
    public boolean search(T searchItem) {
        DoubleLinkedListNode<T> ptrA = first;
        DoubleLinkedListNode<T> ptrB = last;
        while (ptrA != ptrB) {
            if (ptrA.info == searchItem) return true;
            if (ptrB.info == searchItem) return true;
            ptrA = ptrA.next;
            ptrB = ptrB.back;
        }
        return false;
    }

    @Override
    public void insertNode(T insertItem) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
        newNode.info = insertItem;
        if (count == 0)
            first = newNode;
        else {
            last.next = newNode;
            newNode.back = last;
        }
        last = newNode;
        count++;
    }

    @Override
    public void deleteNode(T deleteItem) {
        DoubleLinkedListNode<T> node = first;
        if (deleteItem.equals(first.info)) {
            first = first.next;
            System.gc();
            count--;
        } else {
            node = node.next;
            while (node != null) {
                if (node.info.equals(deleteItem)) {
                    node.back.next = node.next;
                    node.next.back = node.back;
                    System.gc();
                    count--;
                }
                node = node.next;
            }
        }

    }
    @Override
    public String recursiveToString() {
        DoubleLinkedListNode<T> node = first;
        return "[head] - " + recursiveHelper(node, true);
    }

    @Override
    public String backwardsString() {
        String str = "[tail] - ";
        DoubleLinkedListNode<T> node = last;
        while (node != null) {
            str += node.info + " - ";
            node = node.back;
        }
        str += "[head]";
        return str;
    }

    @Override
    public String recursiveBackwardsString() {
        DoubleLinkedListNode<T> node = last;
        return "[tail] - " + recursiveHelper(node, false);
    }

    @Override
    public void copy(DoubleLinkedListClass<T> otherList) {
        if (!otherList.isEmptyList()) {
            DoubleLinkedListNode<T> node = otherList.first;
            while (node != null) {
                insertNode(node.info);
                node = node.next;
            }
        }
    }

    @Override
    public void reversedCopy(DoubleLinkedListClass<T> otherList) {
        initializeList();
        DoubleLinkedListNode<T> node = otherList.last;
        while (node != null) {
            insertNode(node.info);
            node = node.back;
        }
    }

    private String recursiveHelper(DoubleLinkedListNode<T> node, boolean isForward) {
        if (node != null)
            return node.info + " - " + (isForward ?
                    recursiveHelper(node.next, true) :
                    recursiveHelper(node.back, false));
        return isForward ? "[tail]" : "[head]";
    }
}
