package s2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

/*************************************************************************
 * Compilation: javac Point.java Execution: Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 * @author Magnus M. Halldorsson, email: mmh@ru.is
 *************************************************************************/
public class Point implements Comparable<Point> {

    public final int x, y;

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        public int compare(Point point1, Point point2) {

            double slope1 = slopeTo(point1);
            double slope2 = slopeTo(point2);

            if (slope1 < slope2) {
                return -1;
            }
            if (slope1 > slope2) {
                return 1;
            }
            return 0;
        }
    };


    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
        return (double) (that.y - this.y) / (that.x - this.x);
    }


    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinates
     */
    public int compareTo(Point that) {

        if ((this.y < that.y) || (this.x < that.x && this.y == that.y))
            return -1;
        else if (this.y == that.y && this.x == that.x)
            return 0;
        else
            return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        /*
         * Do not modify
         */
        In in = new In("input_from_S2_main_1");
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        out.printf("Testing slopeTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].slopeTo(points[i - 1]));
        }
        out.printf("Testing compareTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].compareTo(points[i - 1]));
        }
        out.printf("Testing SLOPE_ORDER comparator...\n");
        for (int i = 2; i < points.length; i++) {
            out.println(points[i].SLOPE_ORDER.compare(points[i - 1],
                    points[i - 2]));
        }
    }
}
