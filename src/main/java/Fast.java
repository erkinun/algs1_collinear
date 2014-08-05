import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ERKIN on 03/08/2014.
 */
public class Fast {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "input filename must be supplied as argument");
        }

        In in = new In(args[0]);

//        In in = new In(
//                "/Users/erkin.unlu/workspace/coursera/algs1/algs1_collinear/config/inputs/input8.txt");

        int arraySize = in.readInt();
        Point[] points = new Point[arraySize];

        int index = 0;
        while (in.hasNextLine() && index < arraySize) {
            points[index++] = new Point(in.readInt(), in.readInt());
        }

        List<Point[]> lineSegments = new ArrayList<Point[]>();
        for (Point p : points) {

            //StdOut.println("checking point: " + p);

            Point[] tempPoints = Arrays.copyOf(points, points.length);
            Arrays.sort(tempPoints, p.SLOPE_ORDER);

//            StdOut.println("temp sorted array");
//            for (Point p1 : tempPoints) {
//                StdOut.println(p1 + " slope: " + p.slopeTo(p1));
//            }

            double slpVal = p.slopeTo(tempPoints[0]);
            int eqSlopeCount = 1;
            for (int i = 1; i < tempPoints.length; i++) {
                double tempSlp = p.slopeTo(tempPoints[i]);

                if (Double.compare(slpVal, tempSlp) == 0) {
                    eqSlopeCount++;
                }
                else {
                    if (eqSlopeCount >= 3) {

                        //StdOut.println("slope same count: " + eqSlopeCount);

                        //take out this sub segment
                        //take p and eqSlopeCount back elements
                        Point[] sub = Arrays.copyOfRange(tempPoints,
                                i - eqSlopeCount, i);
                        Point[] subExtended = Arrays.copyOf(sub, sub.length + 1);
                        subExtended[subExtended.length - 1] = p;
                        Arrays.sort(subExtended);
                        if (!lineSegments.contains(subExtended)) {
                            lineSegments.add(subExtended);
                        }

                    }

                    eqSlopeCount = 1;
                    slpVal = tempSlp;
                }

                //edge case
                if (i == points.length -1 && eqSlopeCount >= 3) {
                    //take out this sub segment
                    Point[] sub = Arrays.copyOfRange(tempPoints,
                            i - eqSlopeCount, i+1);
                    Point[] subExtended = Arrays.copyOf(sub, sub.length + 1);
                    subExtended[subExtended.length - 1] = p;
                    Arrays.sort(subExtended);
                    if (!lineSegments.contains(subExtended)) {
                        lineSegments.add(subExtended);
                    }
                }
            }
        }

        for (Point[] lineSegment: lineSegments) {
            Arrays.sort(lineSegment);

            int pointIndex = 0;
            for (Point p : lineSegment) {
                if (pointIndex < lineSegment.length - 1) {
                    StdOut.print(p.toString() + " -> ");
                }
                else {
                    StdOut.print(p.toString());
                }
                pointIndex++;
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
