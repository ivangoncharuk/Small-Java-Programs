package cosc237.lab8.classes;

import cosc237.lab8.interfaceAbstract.Shape3D;

public class RectangularPrism implements Shape3D {
    private final double length;
    private final double width;
    private final double height;

    public RectangularPrism() {
        length = 0;
        width = 0;
        height = 0;
    }

    public RectangularPrism(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return 2 * (length * width + width * height + length * height);
    }

    public double getVolume() {
        return length * width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RectangularPrism rPrism)
            return length == rPrism.getLength() &&
                   width == rPrism.getWidth() &&
                   height == rPrism.getHeight();
        return false;
    }

    public String toString() {
        return String.format("For this rectangular prism the base has the length = %.1f and the width = %.1f\n" +
                             "The height of the prism = %.1f", length, width, height);
    }

}
