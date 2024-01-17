package gr.aueb.cf.OOProjects.ch15;

/**
 * Defines a three-dimension point.
 */
public class Point3D extends Point2D {
    private double z;

    public Point3D() {
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    /**
     * Returns the status of a 3-d point as a
     * string.
     *
     * @return     a string, which represents
     *             the 3-d point's status.
     */
    @Override
    public String toString() {
        return super.toString() + ", (" + z + ")";
    }


    /**
     * Gives the distance of α 3-d point (x, y, z) from
     * the origin of the axes (0.0, 0.0, 0.0).
     *
     * @return      the distance.
     */
    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(z, 2));
    }
}
