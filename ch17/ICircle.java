package gr.aueb.cf.OOProjects.ch17;

/**
 * The {@link ICircle} interface represents a circular shape.
 * Extends {@link IShape} and {@link ITwoDimensional} interfaces.
 * Classes which implement this interface should provide method
 * to calculate the shape's diameter.
 */
public interface ICircle extends IShape, ITwoDimensional {

    /**
     * Calculates and return a circular shape's diameter.
     *
     * @return          the diameter of the circular shape.
     */
    double getDiameter();
}
