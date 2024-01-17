package gr.aueb.cf.OOProjects.ch15;

/**
 * Defines a two-dimension point.
 */
public class Point2D extends Point {
    private double y;

    public Point2D() {

    }

    public Point2D(double x, double y) {
        super(x);
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns the status of the 2-d point as a
     * string.
     *
     * @return     a string, which represents
     *             the 2-d point's status.
     */
    @Override
    public String toString() {
        return super.toString() + ", (" + y + ")";
    }


    /**
     * Gives the distance of α 2-d point (x,y) from
     * the origin of the axes (0.0, 0.0).
     *
     * @return      the distance.
     */
    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt(Math.pow(getX(), 2) + Math.pow(y, 2));
    }
}
