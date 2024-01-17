package gr.aueb.cf.OOProjects.ch16.proj1;

/**
 * {@link Circle} class extends {@link AbstractShape}.
 */
public class Line extends AbstractShape {
    private double length;

    public Line() {
    }

    public Line(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
