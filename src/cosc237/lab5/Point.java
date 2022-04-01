package cosc237.lab5;

/*
A method named distanceFromOrigin to calculate the distance between a point and the origin at(0, 0)
A method named distance to calculate the distance from a point to a given point.
A method named translate to shift the location of a point by a given amount.
A method named slope that returns the slope of the line between this Point object and a given Point object.
 */
public class Point {
    // note x and y must be positive
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * slope = (y2-y1)/(x2-x1)
     *
     * @param p (x2, y2)
     * @return The slope between two Points.
     */
    public double slope(Point p) {
        if (isHorizontal(p)) {
            if (isVertical(p))
                System.out.println("Slope is infinite!");
            return 0;
        }
        return (double) (p.y - this.y) / (p.x - this.x);
    }

    /**
     * Basically, are the x values equal
     *
     * @param p a Point
     * @return {@code true} if both points have same x.
     */
    public boolean isVertical(Point p) {
        return this.x == p.x;
    }

    /**
     * Basically, are the y values equal
     *
     * @param p a Point
     * @return {@code true} if both points have same y.
     */
    public boolean isHorizontal(Point p) {
        return this.y == p.y;
    }

    /**
     * Translates a point by a given x and y value.
     *
     * @param x x value
     * @param y y value
     */
    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }


    /**
     * distance = √[(x2 − x1)2 + (y2 − y1)2]
     *
     * @param p another Point object
     * @return the distance between this point and another point
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    /**
     * distance from origin = √[(x2 − x1)2 + (y2 − y1)2]
     *
     * @return the distance from this point to the origin (0, 0)
     */
    public double distanceFromOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Point getCopy() {
        return new Point(x, y);
    }

    public void copy(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public boolean equals(Point p) {
        return this.x == p.x && this.y == p.y;
    }

    public void print() {
        System.out.printf("(%d, %d)", x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
