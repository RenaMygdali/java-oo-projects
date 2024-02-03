package gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions;

public class AccountNotFoundException extends Exception {
    private static final long serialVersionUID = 987345089344L;

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
