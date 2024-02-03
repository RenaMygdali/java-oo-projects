package gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions;

public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 177299L;

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient balance " + balance + "for amount " + amount);
    }
}
