package gr.aueb.cf.OOProjects.ch18_accounts_big.dao;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.JointAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JointAccountDAOImpl implements IJointAccountDAO {
    List <JointAccount> jointAccounts = new ArrayList<>();

    @Override
    public JointAccount insert(JointAccount jointAccount) {
        jointAccounts.add(jointAccount);
        return jointAccount;
    }

    @Override
    public JointAccount update(JointAccount oldJointAccount, JointAccount newJointAccount) {
        jointAccounts.set(jointAccounts.indexOf(oldJointAccount), newJointAccount);
        return newJointAccount;
    }

    @Override
    public void deleteByIban(String iban) {
        jointAccounts.removeIf(joinAcc -> joinAcc.getAccount().getIban().equals(iban));
    }

    @Override
    public JointAccount getByIban(String iban) {
        Optional<JointAccount> jointAccount = jointAccounts.stream()
                .filter(acc -> acc.getAccount().getIban().equals(iban))
                .findFirst();

        return jointAccount.orElse(null);
    }

    @Override
    public List<JointAccount> getAll() {
        return new ArrayList<>(jointAccounts);
    }

    @Override
    public void updateBalance(JointAccount jointAccount, double newBalance) {
        int index = 0;

        index = jointAccounts.indexOf(jointAccount);
        jointAccount.getAccount().setBalance(newBalance);
        jointAccounts.set(index, jointAccount);
    }

    @Override
    public boolean ibanNotExist(String iban) {
        return jointAccounts.stream()
                .noneMatch(acc -> acc.getAccount().getIban().equals(iban));
    }

    @Override
    public boolean isSsnValid(String iban, String ssn) {
        JointAccount jointAccount = getByIban(iban);

        return jointAccount.getAccount().getHolder().getSsn().equals(ssn);
    }
}
