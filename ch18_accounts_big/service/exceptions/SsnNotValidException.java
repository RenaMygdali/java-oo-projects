package gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions;

public class SsnNotValidException extends Exception {
    private static final long serialVersionUID = 534523L;

    public SsnNotValidException() {
    }

    public SsnNotValidException(String ssn) {
        super(ssn);
    }
}
