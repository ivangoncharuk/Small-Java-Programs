package cosc237.lab7.classes;

public class CD extends MediaItem {
    // artist and genre.
    private String artist;
    private String genre;

    public CD() {
        artist = "NO_ARTIST";
        genre = "NO_GENRE";
    }

    @Override
    public void addItem(Object o) {
        //todo
    }

    @Override
    public void print() {

    }

    public CD(String id, String title, int numberOfCopies, double runTime, String artist, String genre) {
        super(id, title, numberOfCopies, runTime);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return this + String.format("ARTIST: %s\nGENRE: %s\nNUMBER OF COPIES: %d\n", artist, genre, getNumberOfCopies());
    }

}
