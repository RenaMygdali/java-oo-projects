package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.IAccountDAO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.*;

public class OverdraftAccountServiceImpl extends BaseAccountServiceImpl implements IOverdraftAccountService {

    public OverdraftAccountServiceImpl() {
    }


    public OverdraftAccountServiceImpl(IAccountDAO accountDAO) {
        super(accountDAO);
    }

    @Override
    public void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException, SsnNotValidException, NegativeAmountException{
        double currentBalance;
        double newBalance;

        try {
            if (accountDAO.ibanNotExist(iban)) {
                throw new AccountNotFoundException("Account not found");
            }
            if (!accountDAO.isSsnValid(iban, ssn)) {
                throw new SsnNotValidException("The given ssn does not belong to the given iban");
            }

            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }

            currentBalance = accountDAO.getByIban(iban).getBalance();

            newBalance = currentBalance - amount;
            accountDAO.updateBalance(accountDAO.getByIban(iban), newBalance);

        } catch (AccountNotFoundException | SsnNotValidException | NegativeAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
