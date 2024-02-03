package gr.aueb.cf.OOProjects.ch18.dao;

import gr.aueb.cf.OOProjects.ch18.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl implements IAccountDAO {
    private static final List<Account> accounts = new ArrayList<>();

    public AccountDAOImpl() {
    }

    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Account newAccount, Account oldAccount) {
        accounts.set(accounts.indexOf(oldAccount), newAccount);
        return newAccount;
    }

    @Override
    public void deleteByIban(String iban) {
        accounts.removeIf(account -> account.getIban().equals(iban));
    }

    @Override
    public Account getByIban(String iban) {
        Optional<Account> account = accounts.stream()
                .filter(acc -> acc.getIban().equals(iban))
                .findFirst();

        return account.orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }


    @Override
    public void updateBalance(Account account, double newBalance) {
        int index = 0;

        index = accounts.indexOf(account);
        account.setBalance(newBalance);
        accounts.set(index, account);
    }

    @Override
    public boolean ibanNotExist(String iban) {
        return accounts.stream()
                .noneMatch(acc -> acc.getIban().equals(iban));
    }

    @Override
    public boolean isSsnValid(String iban, String ssn) {
        Account account = getByIban(iban);

        return account.getHolder().getSsn().equals(ssn);
    }
}
