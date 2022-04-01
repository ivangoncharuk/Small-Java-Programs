package cosc237.lab7.classes;

public class JournalPaper extends WrittenItem {
    private int yearReleased;

    public JournalPaper() {
        super();
        yearReleased = 0;
    }

    @Override
    public void addItem(Object o) {

    }

    @Override
    public void print() {

    }

    public JournalPaper(String id, String title, int numberOfCopies, String author, int yearReleased) {
        super(id, title, numberOfCopies, author);
        this.yearReleased = yearReleased;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }
    @Override
    public String toString() {
        return this + String.format("YEAR RELEASED: %d\nNUMBER OF COPIES: %d\n",
                yearReleased, getNumberOfCopies());
    }

}
