package gr.aueb.cf.OOProjects.ch15;

/**
 * Defines a one-dimension point.
 */
public class Point {
    private double x;

    public Point() {
    }

    public Point(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "(" + x + ")";
    }

    public double getDistanceFromOrigin() {
        return x;
    }
}

