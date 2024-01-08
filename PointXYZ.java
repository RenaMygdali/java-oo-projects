package gr.aueb.cf.OOProjects;

/**
 * The {@link PointXYZ} class represents <i>points</i>
 * in three-dimensional space.
 * It contains {@link PointXYZ#x}, {@link PointXYZ#y} and
 * {@link PointXYZ#z} coordinates.
 *
 * @author RenaMigdali
 */
public class PointXYZ {
    private int x;
    private int y;
    private int z;

    /**
     * Initializes a new {@link PointXYZ}
     * with default values.
     */
    public PointXYZ() {}


    /**
     * Initializes a new {@link PointXYZ}
     * with specific (x, y, z) coordinates.
     *
     * @param x     the x-coordinate.
     * @param y     the y-coordinate.
     * @param z     the z-coordinate.
     */
    public PointXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * Gets the x-coordinate.
     *
     * @return      the value of x-coordinate.
     */
    public int getX() {
        return x;
    }


    /**
     * Sets the x coordinate.
     *
     * @param x     the value of x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * Gets the y-coordinate.
     *
     * @return      the value of y-coordinate.
     */
    public int getY() {
        return y;
    }


    /**
     * Sets the y coordinate.
     *
     * @param y     the value of y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * Gets the z-coordinate.
     *
     * @return      the z-coordinate.
     */
    public int getZ() {
        return z;
    }


    /**
     * Sets the value of z coordinate.
     *
     * @param z     the value of z-coordinate.
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Returns the state of {@link PointXYZ} instance
     * as a String.
     *
     * @return      a string representation
     *              of {@link PointXYZ} instance.
     */
    public String convertToString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
