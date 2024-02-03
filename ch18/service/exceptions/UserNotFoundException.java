package gr.aueb.cf.OOProjects.ch18.service.exceptions;

import gr.aueb.cf.Rena.ch18.model.User;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 8584923423L;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(User user) {
        super("User with ssn " + user.getSsn() + " not found");
    }
}
