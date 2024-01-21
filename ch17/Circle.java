package gr.aueb.cf.OOProjects.ch17;

import java.io.Serializable;
import java.util.Objects;

/**
 * The {@link Circle} class represents a circular shape.
 * Extends the {@link AbstractShape} abstract class and
 * implements the {@link ICircle}, {@link Serializable} and
 * {@link Cloneable} interfaces.
 * Provides methods to calculate and return the area, the
 * circumference and the diameter of the circular shape.
 */
public class Circle extends AbstractShape implements ICircle, Serializable, Cloneable {
    private static final long serialVersionUID = 853475348L;
    private double radius;

    public Circle() {
    }

    public Circle(long id, double radius) {
        super(id);
        this.radius = radius;
    }

    // copy constructor
    public Circle(Circle circle) {
        super(circle);
        this.radius = circle.getRadius();
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates and returns the area of
     * a circular shape.
     *
     * @return      the area of the circular shape.
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }


    /**
     * Calculates and returns the circumference of
     * a circular shape.
     *
     * @return      the circumference of the circular shape.
     */
    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }


    /**
     * Calculates and returns the diameter of
     * a circular shape.
     *
     * @return      the diameter of the circular shape.
     */
    @Override
    public double getDiameter() {
        return radius * 2;
    }



    @Override
    public String toString() {
        return "Circle {id=" + getId() + ", radius=" + radius + "}";
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

        Circle circle = (Circle) o;

        return Objects.equals(radius, circle.getRadius());
    }


    /**
     * Returns a hash code value for an object.
     *
     * @return          the hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }


    /**
     * Creates a clone object.
     *
     * @return      cloned object.
     * @throws CloneNotSupportedException
     *              if the object is not cloneable.
     */
    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }
}
