package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.IJointAccountDAO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.SsnNotValidException;

public class OverdraftJointAccountServiceImpl extends BaseJointAccountServiceImpl implements IOverdraftJointAccountService {

    public OverdraftJointAccountServiceImpl() {
    }

    public OverdraftJointAccountServiceImpl(IJointAccountDAO jointAccountDAO) {
        super(jointAccountDAO);
    }

    @Override
    public void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException,
            SsnNotValidException, NegativeAmountException {

        double currentBalance;
        double newBalance;

        try {
            if (jointAccountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            if (!jointAccountDAO.isSsnValid(iban, ssn)) {
                throw new SsnNotValidException("The given ssn does not belong to the given iban");
            }

            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }

            currentBalance = jointAccountDAO.getByIban(iban).getAccount().getBalance();

            newBalance = currentBalance - amount;
            jointAccountDAO.updateBalance(jointAccountDAO.getByIban(iban), newBalance);

        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
