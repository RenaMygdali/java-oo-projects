package gr.aueb.cf.OOProjects.ch18_accounts_big.service;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.*;

public interface IAccountService extends IBaseAccountService {

    /**
     * Withdraws a certain amount of money from an account
     * IFF the amount to be withdrawn is smaller than the
     * current balance of the account.
     * It validates the given ssn to be equal to account's
     * holder ssn.
     *
     * @param iban        the given iban.
     * @param ssn         the given ssn.
     * @param amount      the amount of money to be withdrawn.
     * @throws
     *      AccountNotFoundException
     *                  if the account does not exist.
     * @throws
     *      SsnNotValidException
     *                 if the given ssn is not equal to account's holder ssn.
     * @throws
     *      NegativeAmountException
     *                 if the amount to be withdrawn is negative.
     * @throws
     *      InsufficientBalanceException
     *                 if the balance of the account is not sufficient.
     */
    void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException,
            SsnNotValidException,
            NegativeAmountException, InsufficientBalanceException;
}
