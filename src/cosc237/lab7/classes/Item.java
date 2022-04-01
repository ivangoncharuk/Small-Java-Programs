package cosc237.lab7.classes;

import java.util.Objects;

public abstract class Item {
    private String id;
    private String title;
    private int numberOfCopies;

    public Item() {
        id = "NO_ID";
        title = "NO_TITLE";
        numberOfCopies = 0;
    }

    public Item(String id, String title, int numberOfCopies) {
        this.id = id;
        this.title = title;
        this.numberOfCopies = numberOfCopies;
    }

    abstract public void addItem(Object o);

    public void checkIn() {
        numberOfCopies += 1;
    }

    public void checkOut() {
        if (numberOfCopies > 0)
            numberOfCopies -= 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public abstract void print();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return numberOfCopies == item.numberOfCopies &&
               Objects.equals(id, item.id) &&
               Objects.equals(title, item.title);
    }

    @Override
    abstract public String toString();
}
/*
1. Implement an abstract superclass called Item and define all common operations on this class
(constructors, getters, setters, equals, toString, print, checkIn, checkOut, addItem, etc).
Have private data for: identification number, title, and number of copies.
 */