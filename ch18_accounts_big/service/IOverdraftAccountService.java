package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.SsnNotValidException;

public interface IOverdraftAccountService extends IBaseAccountService {

    /**
     * Withdraws a certain amount of money from an account
     * regardless the current balance of the account.
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
     */
    void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException,
            SsnNotValidException,
            NegativeAmountException;
}
