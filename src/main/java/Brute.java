import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ERKIN on 03/08/2014.
 */
public class Brute {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("one input file must be given");
        }

        In in = new In(args[0]);

        int arraySize = in.readInt();
        Point[] points = new Point[arraySize];

        int index = 0;
        while (in.hasNextLine() && index < arraySize) {
            points[index++] = new Point(in.readInt(), in.readInt());
        }

        Point p1, p2, p3, p4;

        //get 4 combinations
        List<Point[]> lineSegments = new ArrayList<Point[]>();
        for (int i = 0; i < arraySize - 3; i++) {
            for (int j = i+1; j < arraySize - 2; j++) {
                for (int k = j+1; k < arraySize - 1; k++) {
                    for (int l = k+1; l < arraySize; l++) {
                        //test each combination if collinear
                        p1 = points[i];
                        p2 = points[j];
                        p3 = points[k];
                        p4 = points[l];

                        double slp1 = p1.slopeTo(p2);
                        double slp2 = p1.slopeTo(p3);
                        double slp3 = p1.slopeTo(p4);

                        if (Double.compare(slp1, slp2) == 0
                                && Double.compare(slp1, slp3) == 0) {
                            Point[] lineSegment = new Point[]{p1, p2, p3, p4};
                            Arrays.sort(lineSegment);
                            lineSegments.add(lineSegment);
                        }
                    }
                }
            }
        }

        for (Point[] lineSegment: lineSegments) {

            int pointIndex = 0;
            for (Point p : lineSegment) {

                if ( pointIndex < lineSegment.length - 1 ) {
                    StdOut.print(p.toString() + " -> ");
                }
                else {
                    StdOut.print(p.toString());
                }


            }
            StdOut.println();
        }

        //draw each point
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point point : points) {
            point.draw();
        }

        //draw each line segment
        for (Point[] lineSegment: lineSegments) {
            Point start = lineSegment[0];
            Point end = lineSegment[lineSegment.length-1];
            start.drawTo(end);
        }
    }



}
