package cosc237.lab7.classes;

public abstract class WrittenItem extends Item {
    private String author;
    public WrittenItem() {
        super();
        author = "NO_AUTHOR";
    }

    public WrittenItem(String id, String title, int numberOfCopies, String author) {
        super(id, title, numberOfCopies);
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("AUTHOR: %s\nID: %s\nTITLE: %s\nNUMBER OF COPIES: %d",
                author, getId(), getTitle(), getNumberOfCopies());
    }
//\nNUMBER OF COPIES: %d", runTime, getNumberOfCopies()
}
