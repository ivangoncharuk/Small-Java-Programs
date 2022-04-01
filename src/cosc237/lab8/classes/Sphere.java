package cosc237.lab8.classes;

import cosc237.lab8.interfaceAbstract.Shape3D;

//done
public class Sphere implements Shape3D {
    private final double radius;

    public Sphere() {
        radius = 0;
    }

    public Sphere(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume() {
        return 4.0 * Math.PI * Math.pow(radius, 3) / 3.0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Sphere s)
            return radius == s.radius;
        return false;
    }

    public String toString() {
        return String.format("The radius of this sphere = %.1f", radius);
    }
}