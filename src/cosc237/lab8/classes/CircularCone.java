package cosc237.lab8.classes;

import cosc237.lab8.interfaceAbstract.CircularShapeWithHeight;

public class CircularCone extends CircularShapeWithHeight {
    public CircularCone() {
        super();
    }

    public CircularCone(double radius, double height) {
        super(radius, height);
    }

    public double getArea() {
        double r = getRadius();
        double h = getHeight();
        return Math.PI * r * Math.sqrt(r * r + h * h);
    }

    public double getVolume() {
        return getCrossSectionArea() * getHeight() / 3.0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CircularCone cirCone)
            return getRadius() == cirCone.getRadius() &&
                   getHeight() == cirCone.getHeight();
        return false;
    }

    public String toString() {
        return String.format("For this circular cone the radius = %.1f and the height = %.1f",
                getRadius(), getHeight());
    }
}
