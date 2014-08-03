import org.junit.Test;

import org.junit.Assert;

public class PointTest {

    @Test
    public void testSlopeToNegInf() throws Exception {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(100, 100);

        double slp = p1.slopeTo(p2);


        Assert.assertEquals(0, Double.compare(Double.NEGATIVE_INFINITY, slp));
    }

    @Test
    public void testSlopeToPosInf() throws Exception {
        Point p1 = new Point(100, 150);
        Point p2 = new Point(100, 100);

        double slp = p1.slopeTo(p2);


        Assert.assertEquals(0, Double.compare(Double.POSITIVE_INFINITY, slp));
    }

    @Test
    public void testSlopeToPosZero() throws Exception {
        Point p1 = new Point(80, 100);
        Point p2 = new Point(100, 100);

        double slp = p1.slopeTo(p2);


        Assert.assertEquals(0, Double.compare(0.0, slp));
    }

    @Test
    public void testCompareToEqual() throws Exception {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(100, 100);

        Assert.assertEquals(0, p1.compareTo(p2));
    }

    @Test
    public void testCompareToSmaller() throws Exception {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(100, 150);

        Assert.assertEquals(-1, p1.compareTo(p2));
    }

    @Test
    public void testCompareToSmallerByX() throws Exception {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(120, 100);

        Assert.assertEquals(-1, p1.compareTo(p2));
    }

    @Test
    public void testCompareToBiggerByX() throws Exception {
        Point p1 = new Point(120, 100);
        Point p2 = new Point(100, 100);

        Assert.assertEquals(1, p1.compareTo(p2));
    }

    @Test
    public void testCompareToBiggerByY() throws Exception {
        Point p1 = new Point(80, 120);
        Point p2 = new Point(100, 100);

        Assert.assertEquals(1, p1.compareTo(p2));
    }
}