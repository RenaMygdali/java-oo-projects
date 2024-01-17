package gr.aueb.cf.OOProjects.ch16.proj1;

/**
 * {@link Circle} class extends {@link AbstractShape} and
 * implements {@link ITwoDimensional} interface.
 */
public class Circle extends AbstractShape implements ITwoDimensional {
    private double radius;

    public Circle() {};

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
