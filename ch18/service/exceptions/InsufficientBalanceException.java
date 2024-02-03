package gr.aueb.cf.OOProjects.ch18.service.exceptions;

public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 177299L;

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient balance " + balance + "for amount " + amount);
    }
}
