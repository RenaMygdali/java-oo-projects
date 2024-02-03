package gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.User;

public class UserAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 2786932L;

    public UserAlreadyExistsException(User user) {
        super("User " + user + " already exists");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
