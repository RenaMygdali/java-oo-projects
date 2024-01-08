package gr.aueb.cf.OOProjects.ch12;

/**
 * Creates points as instances of {@link PointXYZ} class.
 *
 * @author RenaMigdali
 */
public class PointXYZApp {

    public static void main(String[] args) {
        PointXYZ p1 = new PointXYZ(3, 8, 20);
        PointXYZ p2 = new PointXYZ(14, 5, 1);
        PointXYZ p3 = new PointXYZ();

        p3.setX(9);
        p3.setY(12);
        p3.setZ(6);

        System.out.println("Point1" + p1.convertToString());
        System.out.println("Point2" + p2.convertToString());
        System.out.println("Point3" + p3.convertToString());

    }
}
