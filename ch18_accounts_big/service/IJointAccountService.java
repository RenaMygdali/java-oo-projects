package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.SsnNotValidException;


public interface IJointAccountService extends IBaseJointAccountService {

    /**
     * Withdraws a certain amount of money from a joint account
     * only if the amount to be withdrawn is smaller than the
     * current balance of the joint account.
     * It validates the given ssn to be equal to joint account's
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
     *                 if the given ssn is not equal to joint account's holder ssn.
     * @throws
     *      NegativeAmountException
     *                 if the amount to be withdrawn is negative.
     * @throws
     *      InsufficientBalanceException
     *                 if the balance of the joint account is not sufficient.
     */
    void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException,
            SsnNotValidException,
            NegativeAmountException, InsufficientBalanceException;
}
