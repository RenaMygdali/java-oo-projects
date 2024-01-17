package gr.aueb.cf.OOProjects.ch16.proj1;

import java.util.Locale;

public class MainShapes {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5.5);
        Circle circle = new Circle(10.2);
        Line line = new Line(20.5);

        rectangle.setId(1);
        circle.setId(2);
        line.setId(3);

        System.out.println("The rectangle with id " + rectangle.getId() + " has " + rectangle.getArea() + " cm area." );
        System.out.printf(Locale.ENGLISH, "The circle with id %d has %.02f cm area", circle.getId(),
                circle.getArea());
        System.out.println();
        System.out.println("The line with id " + line.getId() + " has " + line.getLength() +
                " cm length." );

    }
}
