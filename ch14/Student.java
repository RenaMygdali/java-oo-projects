package gr.aueb.cf.OOProjects.ch14;

/**
 * Javabean class Student.
 */
public class Student {
    private int id;
    private String firstname;
    private String lastname;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String toString () {
        return id + ", " + firstname + ", " + lastname;
    }
}
