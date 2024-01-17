package gr.aueb.cf.OOProjects.ch16.proj2;

public class MainShapesApp {

    public static void main(String[] args) {
        Circle circle = new Circle(1, 5.3);
        Rectangle rect = new Rectangle(2, 10, 6.5);
        Line line = new Line(3, 25);

        System.out.printf("The circle with id %d has:\n Area: %.2f cm\n Circumference: %.2f cm\n " +
                "Diameter: %.2f cm", circle.getId(), circle.getArea(), circle.getCircumference(),
                circle.getDiameter());
        System.out.println("\n");

        System.out.printf("The rectangle with id %d has:\n Area: %.2f cm\n Circumference: %.2f ",
                rect.getId(), rect.getArea(), rect.getCircumference());
        System.out.println("\n");

        System.out.printf("The line with id %d has:\n Length: %.2f cm", line.getId(),
                line.getLength());
    }
}
