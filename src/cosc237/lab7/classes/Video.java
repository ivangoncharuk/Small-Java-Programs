package cosc237.lab7.classes;

public class Video extends MediaItem {
    //private data for director, genre and year released.
    private String director;
    private String genre;
    private int year;

    public Video() {
        super();
        director = "NO_DIRECTOR";
        genre = "NO_GENRE";
        year = 0;
    }

    public Video(String id, String title, int numberOfCopies, double runTime) {
        super(id, title, numberOfCopies, runTime);
    }

    @Override
    public void addItem(Object o) {

    }

    @Override
    public void print() {

    }

    @Override
    public String toString() {
        return this + String.format("DIREECTOR: %s\nGENRE: %s\nYEAR: %d\nNUMBER OF COPIES: %d\n",
                director, genre, year, getNumberOfCopies());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
