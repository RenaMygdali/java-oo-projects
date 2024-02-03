package gr.aueb.cf.OOProjects.ch18.service;

import gr.aueb.cf.OOProjects.ch18.dto.AccountInsertDTO;
import gr.aueb.cf.OOProjects.ch18.dto.AccountUpdateDTO;
import gr.aueb.cf.OOProjects.ch18.model.Account;
import gr.aueb.cf.OOProjects.ch18.service.exceptions.*;

import java.util.List;

public interface IAccountService {

    /**
     * Creates a new {@link Account} based on the data
     * carried by the {@link AccountInsertDTO}.
     *
     * @param dto       the DTO objects that contains the account data.
     * @return          the resulting {@link Account}.
     */
    Account insertAccount(AccountInsertDTO dto);


    /**
     * Updates an existing {@link Account} based on the
     * data carried by the DTO {@link AccountUpdateDTO}.
     *
     * @param oldDTO        the DTO object with the data to be updated.
     * @param newDTO        the DTO object with the data to update with.
     * @return              the new {@link Account}.
     * @throws
     *      AccountNotFoundException
     * @throws
     *      UserAlreadyExistsException
     */
    Account updateAccount(AccountUpdateDTO oldDTO, AccountUpdateDTO newDTO) throws AccountNotFoundException, UserAlreadyExistsException;


    /**
     * Removes an existing {@link Account}.
     *
     * @param iban      the {@link Account} iban needed for the
     *                  account to be removed.
     * @throws
     *      AccountNotFoundException
     */
    void deleteAccountByIban(String iban) throws AccountNotFoundException;


    /**
     * Returns an existing {@link Account}.
     *
     * @param iban      the {@link Account} iban needed for
     *                  the account to be returned.
     * @return          the corresponding {@link Account}.
     * @throws
     *      AccountNotFoundException
     */
    Account getAccountByIban(String iban) throws AccountNotFoundException;


    /**
     * Returns all {@link Account} instances.
     *
     * @return      a list with all the accounts.
     */
    List<Account> getAllAccounts();


    /**
     * Deposits a certain amount of money into an {@link Account},
     * thus increasing the balance of the account.
     *
     * @param iban          the {@link Account} iban needed for the
     *                      amount to be deposited.
     * @param amount        the amount of money to be deposited.
     * @throws
     *      NegativeAmountException
     *                  if the amount to be deposited is negative.
     * @throws
     *      AccountNotFoundException
     */
    void deposit(String iban, double amount) throws AccountNotFoundException,
            NegativeAmountException;

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
