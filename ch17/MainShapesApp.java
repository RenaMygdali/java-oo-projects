package gr.aueb.cf.OOProjects.ch17;

public class MainShapesApp {

    public static void main(String[] args) {
        Circle circle = new Circle(1, 5.3);
        Rectangle rect = new Rectangle(2, 10, 6.5);
        Line line = new Line(3, 25);

        System.out.printf("The rectangle with id #%d has:\n Area: %.2f cm\n Circumference: %.2f ",
                rect.getId(), rect.getArea(), rect.getCircumference());
        System.out.println("\n");
        System.out.printf("The line with id #%d has:\n Length: %.2f cm", line.getId(),
                line.getLength());
        System.out.println("\n");

        Circle circle2 = new Circle(4, 5.3);
        Rectangle rect2 = new Rectangle(5, 10, 3.6);
        Line line2 = new Line(6, 7.8);

        System.out.println(circle);
        System.out.println(circle2);
        System.out.println(rect);
        System.out.println(rect2);
        System.out.println(line);
        System.out.println(line2);

        System.out.println();

        System.out.println("The Circle objects are equal: " + circle2.equals(circle));
        System.out.println("The Rectangle objects are equal: " + rect2.equals(rect));
        System.out.println("The Line objects are equal: " + line2.equals(line));

        System.out.println();

        System.out.println("Circles' hash codes are: \na): " + circle.hashCode() + "\nb): " + circle2.hashCode());
        System.out.println("Rectangles' hash codes are: \na): " + rect.hashCode() + "\nb): " + rect2.hashCode());
        System.out.println("Lines' hash codes are: \na): " + line.hashCode() + "\nb): " + line2.hashCode());

        System.out.println();


        try {
            Circle circleCloned = circle2.clone();
            circleCloned.setId(7);
            circleCloned.setRadius(5.9);

            Rectangle rectCloned = rect2.clone();
            rectCloned.setId(8);
            rectCloned.setWidth(6.3);
            rectCloned.setHeight(9.8);

            Line lineCloned = line2.clone();
            lineCloned.setId(9);
            lineCloned.setLength(2.9);

            System.out.println(circle2);
            System.out.println(circleCloned);
            System.out.println(rect2);
            System.out.println(rectCloned);
            System.out.println(line2);
            System.out.println(lineCloned);
        } catch (CloneNotSupportedException e) {
            System.out.println("Not cloneable");
        }
    }
}
