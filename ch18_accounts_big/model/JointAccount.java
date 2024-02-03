package gr.aueb.cf.OOProjects.ch18_accounts_big.model;

import java.util.Objects;

public class JointAccount extends AbstractEntity {
    private Account account;
    private User secondHolder;

    public JointAccount() {}

    public JointAccount(Long id, Account account, User secondHolder) {
        setId(id);
        this.account = account;
        this.secondHolder = secondHolder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getSecondHolder() {
        return secondHolder;
    }

    public void setSecondHolder(User secondHolder) {
        this.secondHolder = secondHolder;
    }

    @Override
    public String toString() {
        return "JointAccount{" +
                "account=" + account +
                ", secondHolder=" + secondHolder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JointAccount that = (JointAccount) o;

        if (!Objects.equals(account, that.account)) return false;
        return Objects.equals(secondHolder, that.secondHolder);
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (secondHolder != null ? secondHolder.hashCode() : 0);
        return result;
    }
}
