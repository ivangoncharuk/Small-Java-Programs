package cosc237.lab8.classes;

public class Cube extends RectangularPrism {
    public Cube() {
        super();
    }

    public Cube(double size) {
        super(size, size, size);
    }

    public String toString() {
        return String.format("For this cube all sides = %.2f", getLength());
    }
}
