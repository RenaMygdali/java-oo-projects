package gr.aueb.cf.OOProjects.ch18.service.exceptions;

public class SsnNotValidException extends Exception {
    private static final long serialVersionUID = 534523L;

    public SsnNotValidException() {
    }

    public SsnNotValidException(String message) {
        super(message);
    }
}
