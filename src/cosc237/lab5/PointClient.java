package cosc237.lab5;

import java.util.Scanner;

import static java.lang.System.out;

enum Messages {
    ENTER_X("Enter the x-coordinate for first point: "),
    ENTER_Y("Enter the y-coordinate for first point: "),
    NOT_AN_INT("Not an integer! Try again! "),
    NOT_POS("ERROR! Should be positive. ");
    String s;

    Messages(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return this.s;
    }
}

public class PointClient {
    public static void main(String[] args) {
        Point p1 = new Point(),
                p2 = new Point(7, 13),
                p3 = new Point(7, 15);

        out.println("---After declaration, constructors invoked--- Using toString():");
        out.printf("\tFirst point is %s\n" +
                   "\tSecond point is %s\n" +
                   "\tThird point is %s\n",
                p1, p2, p3);
        out.printf("Second point %s %s vertically with third point %s\n" +
                   "Second point %s %s horizontally with third point %s\n",
                p2, p2.isVertical(p3) ? "lines up" : "doesn't line up", p3,
                p2, p2.isHorizontal(p3) ? "lines up" : "doesn't line up", p3);
        int x = getInt(Messages.ENTER_X.s, true);
        int y = getInt(Messages.ENTER_Y.s, true);
        p1.set(x, y);
        out.printf("First point (after call to set) is %s\n", p1);
        out.printf("Distance from origin for first point = %f\n" +
                   "Distance from origin for second point = %f\n" +
                   "Distance between first point and second point = %f\n",
                p1.distanceFromOrigin(), p2.distanceFromOrigin(), p1.distance(p2));
        p1.translate(5, 10);
        p2.translate(15, 5);

        out.printf("First point (after call to translate (5, 10)) is %s\n" +
                   "Second point (after call to translate (15, 5)) is %s\n",
                p1, p2);
        out.printf("---Call to equals: The 2 points are %sequal.\n",
                p1.equals(p2) ? "" : "NOT ");
        p2.copy(p1);
        out.printf("First point (after call to copy) is %s\n" +
                   "Second point (after call to copy) is %s\n",
                p1, p2);
        out.printf("---Call to equals after call to copy: The 2 points are %sequal.\n",
                p1.equals(p2) ? "" : "NOT ");
    }

    public static int getInt(String prompt, boolean checkForPosInt) {
        Scanner s = new Scanner(System.in);
        int result;
        while (true) {
            out.print(prompt);
            try {
                result = Integer.parseInt(s.nextLine());
                if (result < 0 && checkForPosInt)
                    out.print(Messages.NOT_POS);
                else
                    return result;
            } catch (NumberFormatException nfe) {
                out.print(Messages.NOT_AN_INT);
            }
        }
    }
}
