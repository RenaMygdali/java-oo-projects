package gr.aueb.cf.OOProjects.ch15;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(5.5);
        Point p2 = new Point2D(3, 4);
        Point p3 = new Point3D(12, 16, 0);

        System.out.println("Point's p1 distance from origin is: " + PointUtil.distanceFromOrigin(p1));
        System.out.println("Point's p2 distance from origin is: " + PointUtil.distanceFromOrigin(p2));
        System.out.println("Point's p3 distance from origin is: " + PointUtil.distanceFromOrigin(p3));
    }
}
