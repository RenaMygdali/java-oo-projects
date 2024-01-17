package gr.aueb.cf.OOProjects.ch15;

/**
 * Defines a one-dimension point.
 */
public class Point {
    private double x;

    public Point() {
    }

    public Point(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }


    /**
     * Returns the status of a 1-d point as a
     * string.
     *
     * @return     a string, which represents
     *             the 3-d point's status.
     */
    @Override
    public String toString() {
        return "(" + x + ")";
    }


    /**
     * Gives the distance of α 1-d point (x) from
     * the origin of the axes (0.0).
     *
     * @return      the distance.
     */
    public double getDistanceFromOrigin() {
        return x;
    }
}

