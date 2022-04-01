package cosc237.lab8.interfaceAbstract;

//done
public abstract class CircularShapeWithHeight extends CircularShape {
    private final double height;

    public CircularShapeWithHeight() {
        super();
        height = 0;
    }

    public CircularShapeWithHeight(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
