package gr.aueb.cf.OOProjects.ch16.proj2;

/**
 * The {@link Line} class represents a line shape.
 * Extends the {@link AbstractShape} abstract class and
 * implements the {@link ILine} interface.
 */
public class Line extends AbstractShape implements ILine {
    private double length;

    public Line() {
    }

    public Line(double length) {
        this.length = length;
    }

    public Line(long id, double length) {
        super(id);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
