package gr.aueb.cf.OOProjects.ch18.service.exceptions;

import gr.aueb.cf.Rena.ch18.model.User;

public class UserAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 2786932L;

    public UserAlreadyExistsException(User user) {
        super("User " + user + " already exists");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
