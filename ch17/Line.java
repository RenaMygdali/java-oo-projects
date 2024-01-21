package gr.aueb.cf.OOProjects.ch17;

import java.io.Serializable;
import java.util.Objects;

/**
 * The {@link Line} class represents a line shape.
 * Extends the {@link AbstractShape} abstract class and
 * implements the {@link ILine}, {@link Serializable} and
 * {@link Cloneable} interfaces.
 */
public class Line extends AbstractShape implements ILine, Serializable, Cloneable {
    private static final long serialVersionUID = 452365438L;
    private double length;

    public Line() {
    }

    public Line(long id, double length) {
        super(id);
        this.length = length;
    }

    // copy constructor
    public Line(Line line) {
        super(line);
        this.length = line.getLength();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Line {id=" + getId() + ", length=" + length + "}";
    }

    /**
     * Checks for equality between two objects.
     *
     * @param o     the object to compare with.
     * @return      true, if they are equal
     *              false, otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Objects.equals(length, line.getLength());
    }


    /**
     * Returns a hash code value for an object.
     *
     * @return          the hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getLength());
    }


    /**
     * Creates a clone object.
     *
     * @return      cloned object.
     * @throws CloneNotSupportedException
     *              if the object is not cloneable.
     */
    @Override
    protected Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }
}
