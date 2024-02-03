package gr.aueb.cf.OOProjects.ch18.service.exceptions;

public class NegativeAmountException extends Exception {
    private static final long serialVersionUID = 12344L;

    public NegativeAmountException(double amount) {
        super("Amount " + amount + " is negative.");
    }
}
