package gr.aueb.cf.OOProjects.ch18_accounts_big.model;

public class OverdraftJointAccount extends JointAccount {

    public OverdraftJointAccount() {}

    public OverdraftJointAccount(Long id, Account account, User secondHolder) {
        super(id, account, secondHolder);
    }
}
