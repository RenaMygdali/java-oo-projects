package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.IJointAccountDAO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.*;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.Account;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.JointAccount;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.User;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;

import java.util.List;

public abstract class BaseJointAccountServiceImpl implements IBaseJointAccountService {
    protected IJointAccountDAO jointAccountDAO;

    public BaseJointAccountServiceImpl() {
    }

    public BaseJointAccountServiceImpl(IJointAccountDAO jointAccountDAO) {
        this.jointAccountDAO = jointAccountDAO;
    }

    @Override
    public JointAccount insertJointAccount(JointAccountInsertDTO dto) {
        if (dto == null) return null;
        JointAccount jointAccount;

        jointAccount = mapJointAccountByInsert(dto);
        return jointAccountDAO.insert(jointAccount);
    }

    @Override
    public JointAccount updateJointAccount(JointAccountUpdateDTO oldDTO,
                                           JointAccountUpdateDTO newDTO) throws AccountNotFoundException {
        if (oldDTO == null || newDTO == null) return null;
        JointAccount oldJointAccount;
        JointAccount newJointAccount;

        try {
            oldJointAccount = mapJointAccountByUpdate(oldDTO);
            newJointAccount = mapJointAccountByUpdate(newDTO);

            if (jointAccountDAO.ibanNotExist(oldJointAccount.getAccount().getIban())) {
                throw new AccountNotFoundException("Account not found");
            }
            return jointAccountDAO.update(oldJointAccount, newJointAccount);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }    }

    @Override
    public void deleteJointAccountByIban(String iban) throws AccountNotFoundException {
        if (iban == null) return;

        try {
            if (jointAccountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            jointAccountDAO.deleteByIban(iban);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public JointAccount getJointAccountByIban(String iban) throws AccountNotFoundException {
        if (iban == null) return null;

        JointAccount jointAccount;

        try {
            jointAccount = jointAccountDAO.getByIban(iban);

            if (jointAccount == null) {
                throw new AccountNotFoundException("Account not found");
            }
            return jointAccount;
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<JointAccount> getAllJoinAccounts() {
        return jointAccountDAO.getAll();
    }

    @Override
    public void deposit(String iban, double amount) throws AccountNotFoundException, NegativeAmountException {
        double currentBalance;
        double newBalance;

        if (iban == null) return;

        try {
            if (jointAccountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }
            currentBalance = jointAccountDAO.getByIban(iban).getAccount().getBalance();
            newBalance = currentBalance + amount;
            jointAccountDAO.updateBalance(jointAccountDAO.getByIban(iban), newBalance);

        } catch (AccountNotFoundException | NegativeAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private JointAccount mapJointAccountByInsert(JointAccountInsertDTO dto) {
        User user = mapUserByInsert(dto.getSecondUserInsertDTO());
        Account account = mapAccountByInsert(dto.getAccountInsertDTO());

        return new JointAccount(dto.getAccountInsertDTO().getId(), account, user);
    }

    private JointAccount mapJointAccountByUpdate(JointAccountUpdateDTO dto) {
        User user = mapUserByUpdate(dto.getSecondUserUpdateDTO());
        Account account = mapAccountByUpdate(dto.getAccountUpdateDTO());

        return new JointAccount(dto.getAccountUpdateDTO().getId(), account, user);
    }

    private Account mapAccountByInsert(AccountInsertDTO dto) {
        User user = mapUserByInsert(dto.getUserInsertDTO());

        return new Account(dto.getId(), dto.getIban(), user, dto.getBalance());
    }

    private Account mapAccountByUpdate(AccountUpdateDTO dto) {
        User user = mapUserByUpdate(dto.getUserUpdateDTO());

        return new Account(dto.getId(), dto.getIban(), user, dto.getBalance());
    }

    private User mapUserByInsert(UserInsertDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }

    private User mapUserByUpdate(UserUpdateDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }
}
