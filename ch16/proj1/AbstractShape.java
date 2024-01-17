package gr.aueb.cf.OOProjects.ch16.proj1;

/**
 * Implements {@link IShape} interface
 * and provides a {@link #setId(long)} method.
 */
public abstract class AbstractShape implements IShape {
    private long id;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
