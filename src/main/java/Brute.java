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
        while (in.hasNextLine()) {
            points[index++] = new Point(in.readInt(), in.readInt());
        }

        //draw each point
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (int i = 0; i < points.length; i++) {
            points[i].draw();
        }
    }

    //read the arg
    //read elems from file
    //put them in array
    //get 4 combinations
    //test each combination if collinear

    //draw each line segment

}
