package gr.aueb.cf.OOProjects.ch17;

import java.io.Serializable;
import java.util.Objects;

/**
 * The {@link Rectangle} class represents a rectangular shape.
 * Extends the {@link AbstractShape} abstract class and
 * implements the {@link IRectangle}, {@link Serializable} and
 * {@link Cloneable} interfaces.
 * Provides methods to calculate and return the area, the
 * circumference and the diameter of the circular shape.
 */
public class Rectangle extends AbstractShape implements IRectangle, Serializable, Cloneable {
    private static final long serialVersionUID = 89572341L;
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(long id, double width, double height) {
        super(id);
        this.width = width;
        this.height = height;
    }

    // copy constructor
    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Calculates and returns the area of
     * a rectangular shape.
     *
     * @return      the area of the rectangular shape.
     */
    @Override
    public double getArea() {
        return width * height;
    }


    /**
     * Calculates and returns the circumference of
     * a rectangular shape.
     *
     * @return      the circumference of the rectangular shape.
     */
    @Override
    public double getCircumference() {
        return (width + height) * 2;
    }



    @Override
    public String toString() {
        return "Rectangle {id=" + getId() + ", width=" + width + ", height=" + height + "}";
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

        Rectangle rectangle = (Rectangle) o;

        if (!Objects.equals(width, rectangle.width)) return false;
        return Objects.equals(height, rectangle.height);
    }


    /**
     * Returns a hash code value for an object.
     *
     * @return          the hash code value.
     */
    @Override
    public int hashCode() {
       return Objects.hash(getWidth(), getHeight());
    }


    /**
     * Creates a clone object.
     *
     * @return      cloned object.
     * @throws CloneNotSupportedException
     *              if the object is not cloneable.
     */
    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }
}
