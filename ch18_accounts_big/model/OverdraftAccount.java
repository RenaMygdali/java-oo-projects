package gr.aueb.cf.OOProjects.ch18_accounts_big.model;

public class OverdraftAccount extends Account {

    public OverdraftAccount() {}

    public OverdraftAccount(Long id, String iban, User holder, double balance) {
        super(id, iban, holder, balance);
    }




}
