package gr.aueb.cf.OOProjects;

import gr.aueb.cf.OOProjects.model.User;
import gr.aueb.cf.OOProjects.model.UserCredentials;

/**
 * Driver class.
 * Creates instances of User and
 * UserCredentials classes.
 */
public class MainUser {

    public static void main(String[] args) {
        User bob = new User(1, "Bob", "Ross");
        UserCredentials bobCred = new UserCredentials(1, "bobUserName", "abcD123!");

        System.out.println("{" + bob.getId() + ", " + bob.getFirstname() + ", " + bob.getLastname() + ", "
                + bobCred.getId() + ", " + bobCred.getUsername() + ", " + bobCred.getPassword() + "}");
    }
}
