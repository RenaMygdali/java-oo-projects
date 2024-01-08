package gr.aueb.cf.OOProjects.ch12.bankapp.model;

/**
 * A JavaBean class with public API.
 * The {@link OverdraftAccount} class represents
 * a joint bank account {@link JointAccount} that
 * allows withdrawal of amounts greater than the balance of the account.
 */
public class OverdraftAccount {
    private final JointAccount account;
    private double balance;

    public OverdraftAccount(JointAccount account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    public JointAccount getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Withdraws any amount of money from the account.
     *
     * @param amount        the amount to withdraw.
     * @param ssn           the given ssn.
     * @throws Exception    if the given ssn is not valid.
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Invalid SSN");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw e;
        }
        balance -= amount;
    }


    /**
     * Returns account's balance.
     *
     * @return      the balance of the account.
     */
    public double getAccountBalance() {
        return balance;
    }


    /**
     * Checks if the given SSN number is valid.
     *
     * @param ssn       the user's ssn.
     * @return          true if the ssn is valid,
     *                  false otherwise.
     */
    private boolean isSsnValid(String ssn) {
        return (this.account.getHolder1().getSsn().equals(ssn) ||
                this.account.getHolder2().getSsn().equals(ssn));
    }


}
