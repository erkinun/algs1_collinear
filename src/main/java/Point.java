/*************************************************************************
 * Name: Erkin Unlu
 * Email: erkinun@gmail.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    private class SlopeOrder implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            double slp1 = slopeTo(p1);
            double slp2 = slopeTo(p2);

            return ((Double) slp1).compareTo(slp2);
        }
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {

        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }

        if (this.y == that.y) {
            return 0.0;
        }

        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }

        return (double) (that.y - this.y)/(double) (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if ((this.x == that.x) && (this.y == that.y)) {
            return 0;
        }

        if ((this.y < that.y) || ((this.y == that.y) && this.x < that.x)) {
            return -1;
        }
        else {
            return 1;
        }


    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {

        Point p1 = new Point(1234, 5678);
        Point p2 = new Point(19000, 10000);
        Point p3 = new Point(18000, 10000);
        Point p4 = new Point(32000, 10000);

        double slp1 = p1.slopeTo(p2);
        double slp2 = p1.slopeTo(p3);
        double slp3 = p1.slopeTo(p4);

        StdOut.println(slp1);
        StdOut.println(slp2);
    }
}
