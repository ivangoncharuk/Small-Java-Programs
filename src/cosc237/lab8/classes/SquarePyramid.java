package cosc237.lab8.classes;

import cosc237.lab8.interfaceAbstract.Shape3D;

public class SquarePyramid implements Shape3D {
    private final double length;
    private final double height;

    public SquarePyramid() {
        length = 0;
        height = 0;
    }

    public SquarePyramid(double l, double h) {
        length = l;
        height = h;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return length * (length + Math.sqrt(length * length + 4 * height * height));
    }

    public double getVolume() {
        return length * length * height / 3.0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SquarePyramid sqPyramid)
            return length == sqPyramid.getLength() &&
                   height == sqPyramid.getHeight();
        return false;
    }

    public String toString() {
        return String.format("For this square pyramid the base has the length = %.1f and the height = %.1f", length, height);
    }
}
