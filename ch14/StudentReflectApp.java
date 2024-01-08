package gr.aueb.cf.OOProjects.ch14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StudentReflectApp {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("gr.aueb.cf.OOProjects.ch14.Student");

            Constructor<?> defaultCtr = clazz.getDeclaredConstructor();
            Student student1 = (Student) defaultCtr.newInstance();
            Method toString = clazz.getMethod("toString");
            System.out.println(toString.invoke(student1));

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
