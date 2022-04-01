package cosc237.lab8.classes;

import cosc237.lab8.interfaceAbstract.CircularShapeWithHeight;

public class Cylinder extends CircularShapeWithHeight {
    public Cylinder() {
        super();
    }

    public Cylinder(double radius, double height) {
        super(radius, height);
    }

    public double getArea() {
        return getCrossSectionPerimeter() * getHeight() + 2 * getCrossSectionArea();
    }

    public double getVolume() {
        return getCrossSectionArea() * getHeight();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cylinder c)
            return getRadius() == c.getRadius() &&
                   getHeight() == c.getHeight();
        return false;
    }

    public String toString() {
        return String.format("For this cylinder the radius = %.2f and the height = %.2f", getRadius(), getHeight());
    }
}
