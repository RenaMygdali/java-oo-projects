package gr.aueb.cf.OOProjects.ch17;

import java.io.*;

public class MainDeserialize {

    public static void main(String[] args) {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("C:/tmp/circle.ser"))) {
            Circle circle4 = (Circle) ois.readObject();
            System.out.println("Circle successfully read");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException | ClassNotFoundException e1) {
            System.out.println("Not serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("C:/tmp/rectangle.ser"))) {
            Rectangle rect3 = (Rectangle) ois.readObject();
            System.out.println("Rectangle successfully read");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException | ClassNotFoundException e1) {
            System.out.println("Not serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("C:/tmp/line.ser"))) {
            Line line3 = (Line) ois.readObject();
            System.out.println("Line successfully read");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException | ClassNotFoundException e1) {
            System.out.println("Not serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
