package gr.aueb.cf.OOProjects.bankapp.model;


import gr.aueb.cf.ch12.Holder;

/**
 * Immutable class for a joint bank account
 * (contains two Holders, immutable instances).
 */
public final class JointAccount {
    private final Holder holder1;
    private final Holder holder2;
    private final String iban;

    public JointAccount(Holder holder1, Holder holder2, String iban) {
        this.holder1 = holder1;
        this.holder2 = holder2;
        this.iban = iban;
    }

    public Holder getHolder1() {
        return holder1;
    }

    public Holder getHolder2() {
        return holder2;
    }

    public String getIban() {
        return iban;
    }
}
