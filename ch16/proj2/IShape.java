package gr.aueb.cf.OOProjects.ch16.proj2;

/**
 * The {@link IShape} interface represents any
 * geometrical shape. Classes which implement this interface
 * should provide a method to return the unique identification
 * (id) of the shape.
 */
public interface IShape {

    /**
     * Provides the unique identification (id) of any shape.
     *
     * @return      the unique id.
     */
    long getId();
}
