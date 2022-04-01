package cosc237.lab7.classes;

public abstract class MediaItem extends Item {

    private double runTime;

    public MediaItem() {
        super();
        runTime = 0;
    }
    public MediaItem(String id, String title, int numberOfCopies, double runTime) {
        super(id, title, numberOfCopies);
        this.runTime = runTime;
    }
    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return String.format("RUNTIME: %f minutes\nNUMBER OF COPIES: %d", runTime, getNumberOfCopies());
    }
}
