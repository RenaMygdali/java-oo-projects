package gr.aueb.cf.OOProjects.ch18.service;

import gr.aueb.cf.OOProjects.ch18.dao.IAccountDAO;
import gr.aueb.cf.OOProjects.ch18.dto.AccountInsertDTO;
import gr.aueb.cf.OOProjects.ch18.dto.AccountUpdateDTO;
import gr.aueb.cf.OOProjects.ch18.model.Account;
import gr.aueb.cf.OOProjects.ch18.service.exceptions.*;
import gr.aueb.cf.OOProjects.ch18.dto.UserInsertDTO;
import gr.aueb.cf.OOProjects.ch18.dto.UserUpdateDTO;
import gr.aueb.cf.OOProjects.ch18.model.User;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDAO accountDAO;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account insertAccount(AccountInsertDTO dto){
        if (dto == null) return null;
        Account account;

        account = mapAccountByInsert(dto);
        return accountDAO.insert(account);
    }

    @Override
    public Account updateAccount(AccountUpdateDTO oldDTO, AccountUpdateDTO newDTO) throws AccountNotFoundException, UserAlreadyExistsException {
        if (oldDTO == null || newDTO == null) return null;
        Account oldAccount;
        Account newAccount;

        try {
            oldAccount = mapAccountByUpdate(oldDTO);
            newAccount = mapAccountByUpdate(newDTO);

            if (accountDAO.ibanNotExist(oldAccount.getIban())) {
                throw new AccountNotFoundException("Account not found");
            }

            if (accountDAO.isSsnValid(oldAccount.getIban(), newAccount.getHolder().getSsn())) {
                throw new UserAlreadyExistsException("User already exists to the old account.");
            }
            return accountDAO.update(oldAccount, newAccount);
        } catch (AccountNotFoundException | UserAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAccountByIban(String iban) throws AccountNotFoundException {
        if (iban == null) return;

        try {
            if (accountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            accountDAO.deleteByIban(iban);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccountByIban(String iban) throws AccountNotFoundException {
        if (iban == null) return null;

        Account account;

        try {
            account = accountDAO.getByIban(iban);

            if (account == null) {
                throw new AccountNotFoundException("Account not found");
            }
            return account;
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDAO.getAll();
    }

    @Override
    public void deposit(String iban, double amount) throws AccountNotFoundException,
            NegativeAmountException {
        double currentBalance;
        double newBalance;

        if (iban == null) return;

        try {
            if (accountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }
            currentBalance = accountDAO.getByIban(iban).getBalance();
            newBalance = currentBalance + amount;
            accountDAO.updateBalance(accountDAO.getByIban(iban), newBalance);

        } catch (AccountNotFoundException | NegativeAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException,
            SsnNotValidException, NegativeAmountException, InsufficientBalanceException {
        double currentBalance;
        double newBalance;

        try {
            if (accountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            if (!accountDAO.isSsnValid(iban, ssn)) {
                throw new SsnNotValidException("The given ssn " + ssn + " does not belong to the " +
                        "iban " + iban);
            }

            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }

            currentBalance = accountDAO.getByIban(iban).getBalance();

            if (amount > currentBalance) {
                throw new InsufficientBalanceException(currentBalance, amount);
            }
            newBalance = currentBalance - amount;
            accountDAO.updateBalance(accountDAO.getByIban(iban), newBalance);

        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException |
                 InsufficientBalanceException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Account mapAccountByInsert(AccountInsertDTO dto) {
       User user = mapUserByInsert(dto.getUserInsertDTO());

        return new Account(dto.getIban(), user, dto.getBalance());
    }

    private Account mapAccountByUpdate(AccountUpdateDTO dto) {
        User user = mapUserByUpdate(dto.getUserUpdateDTO());

        return new Account(dto.getIban(), user, dto.getBalance());
    }

    private User mapUserByInsert(UserInsertDTO dto) {
        return new User(dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }

    private User mapUserByUpdate(UserUpdateDTO dto) {
        return new User(dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }
}
