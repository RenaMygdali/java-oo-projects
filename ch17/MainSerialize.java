package gr.aueb.cf.OOProjects.ch17;

import java.io.*;

public class MainSerialize {

    public static void main(String[] args) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("C:/tmp/circle.ser"))) {
            Circle circle4 = new Circle(10, 6.3);
            oos.writeObject(circle4);
            System.out.println("Circle with id #" + circle4.getId() + " successfully saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e1) {
            System.out.println("Not serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("C:/tmp/rectangle.ser"))) {
            Rectangle rect3 = new Rectangle(11, 4.1, 8);
            oos.writeObject(rect3);
            System.out.println("Rectangle with id #" + rect3.getId() + " successfully saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e1) {
            System.out.println("Not serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("C:/tmp/line.ser"))) {
            Line line3 = new Line(12, 9.7);
            oos.writeObject(line3);
            System.out.println("Line with id #" + line3.getId() + " successfully saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e1) {
            System.out.println("Not serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
