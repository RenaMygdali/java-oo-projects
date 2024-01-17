package gr.aueb.cf.OOProjects.ch16.proj2;

/**
 * The {@link AbstractShape} abstract class implements
 * the {@link IShape} interface.
 * It provides methods to get and set a shape's
 * unique identification (id).
 */
public abstract class AbstractShape implements IShape {
    private long id;

    public AbstractShape() {
    }

    public AbstractShape(long id) {
        this.id = id;
    }

    /**
     * Provides the unique identification (id)
     * of a shape.
     *
     * @return      the shape's id.
     */
    @Override
    public long getId() {
        return id;
    }


    /**
     * Sets the unique identification (id)
     * of a shape.
     *
     * @param id      a number which represents
     *                the shape's id.
     */
    public void setId(long id) {
        this.id = id;
    }
}
