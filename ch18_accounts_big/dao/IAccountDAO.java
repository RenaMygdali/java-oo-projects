package gr.aueb.cf.OOProjects.ch18_accounts_big.dao;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.Account;

import java.util.List;

public interface IAccountDAO {

    /**
     * Inserts a new {@link Account} instance in the datasource.
     *
     * @param account       the model object that contains the account's data.
     * @return              the resulting {@link Account}.
     */
    Account insert(Account account);


    /**
     * Updates an existing {@link Account} instance.
     *
     * @param oldAccount        the {@link Account} instance to be updated.
     * @param newAccount        the {@link Account} instance to update with.
     * @return                  the new {@link Account} instance.
     */
    Account update(Account oldAccount, Account newAccount);


    /**
     * Removes an existing {@link Account} instance based on
     * its iban.
     *
     * @param iban      the {@link Account} iban of the instance
     *                  to be removed.
     */
    void deleteByIban(String iban);


    /**
     * Returns an existing {@link Account} instance based on its
     * iban.
     *
     * @param iban      the {@link Account} iban of the instance to
     *                  be returned.
     * @return          the resulting {@link Account} instance.
     */
    Account getByIban(String iban);


    /**
     * Returns all the {@link Account} instances from the
     * datasource.
     *
     * @return      the resulting list with the accounts.
     */
    List<Account> getAll();


    /**
     * Updates the balance of an {@link Account}.
     *
     * @param account       the target account.
     * @param newBalance    the new balance of the {@link Account}
     *                      to update with.
     */
    void updateBalance(Account account, double newBalance);


    /**
     * Checks if an {@link Account} already exists based on the
     * given iban.
     *
     * @param iban      the account's iban needed for the check
     *                  to be made.
     * @return          true, if the account already exists,
     *                  false, otherwise.
     */
    boolean ibanNotExist(String iban);


    /**
     * Checks if the given ssn belongs to a specific
     * {@link Account} based on the given iban.
     *
     * @param iban      the given iban for the target account.
     * @param ssn       the given ssn to validate.
     * @return          true, if the given ssn belongs to the
     *                  specific account,
     *                  false, otherwise.
     */
    boolean isSsnValid(String iban, String ssn);

}
