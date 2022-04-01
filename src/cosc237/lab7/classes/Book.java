package cosc237.lab7.classes;

public class Book extends WrittenItem{
    //no private data
    public Book() {
        super();
    }

    @Override
    public void addItem(Object o) {
        if (o instanceof Book b) {
            b.checkIn();
        }
    }

    @Override
    public void print() {
        System.out.println("Print info about a book: ");
        System.out.println(this);
    }

    public Book(String id, String title, int numberOfCopies, String author) {
        super(id, title, numberOfCopies, author);
    }

    @Override
    public String toString() {
        return String.format("%sNUMBER OF COPIES: %d\n", super.toString(), getNumberOfCopies());
    }
}
