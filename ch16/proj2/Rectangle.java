package gr.aueb.cf.OOProjects.ch16.proj2;

/**
 * The {@link Rectangle} class represents a rectangular shape.
 * Extends the {@link AbstractShape} abstract class and
 * implements the {@link IRectangle} interface.
 * Provides methods to calculate and return the area, the
 * circumference and the diameter of the circular shape.
 */
public class Rectangle extends AbstractShape implements IRectangle {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(long id, double width, double height) {
        super(id);
        this.width = width;
        this.height = height;
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
}
