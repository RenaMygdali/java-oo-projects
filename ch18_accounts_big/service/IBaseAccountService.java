package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.AccountInsertDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.AccountUpdateDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.Account;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface IBaseAccountService {

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
}
