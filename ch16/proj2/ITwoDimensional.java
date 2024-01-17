package gr.aueb.cf.OOProjects.ch16.proj2;

/**
 * The {@link ITwoDimensional} interface represents
 * a two-dimensional shape. Classes which implement this
 * interface should provide methods to calculate and return
 * shape's area and circumference.
 */
public interface ITwoDimensional {

    /**
     * Calculates and returns the area of
     * a two-dimensional shape.
     *
     * @return          the area of the shape.
     */
    double getArea();


    /**
     * Calculates and returns the circumference of
     * a two-dimensional shape.
     *
     * @return          the circumference of the shape.
     */
    double getCircumference();
}
