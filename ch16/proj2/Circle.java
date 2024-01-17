package gr.aueb.cf.OOProjects.ch16.proj2;

/**
 * The {@link Circle} class represents a circular shape.
 * Extends the {@link AbstractShape} abstract class and
 * implements the {@link ICircle} interface.
 * Provides methods to calculate and return the area, the
 * circumference and the diameter of the circular shape.
 */
public class Circle extends AbstractShape implements ICircle {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(long id, double radius) {
        super(id);
        this.radius = radius;
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
}
