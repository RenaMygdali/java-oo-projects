package gr.aueb.cf.OOProjects.ch18_accounts_big.dao;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.JointAccount;

import java.util.List;

public interface IJointAccountDAO {

    /**
     * Inserts a new {@link JointAccount} instance in the datasource.
     *
     * @param jointAccount      the model object that contains the joint
     *                          account's data.
     * @return                  the resulting {@link JointAccount}.
     */
    JointAccount insert(JointAccount jointAccount);


    /**
     * Updates an existing {@link JointAccount} instance.
     *
     * @param oldJointAccount           the {@link JointAccount} instance
     *                                  to be updated.
     * @param newJointAccount           the {@link JointAccount} instance
     *                                  to update with.
     * @return                          the new {@link JointAccount} instance.
     */
    JointAccount update(JointAccount oldJointAccount, JointAccount newJointAccount);


    /**
     * Removes an existing {@link JointAccount} instance based on
     * its iban.
     *
     * @param iban      the {@link JointAccount} iban of the instance
     *                  to be removed.
     */
    void deleteByIban(String iban);


    /**
     * Returns an existing {@link JointAccount} instance based on its
     * iban.
     *
     * @param iban          the {@link JointAccount} iban of the instance to
     *                      be returned.
     * @return              the resulting {@link JointAccount} instance.
     */
    JointAccount getByIban(String iban);


    /**
     * Returns all the {@link JointAccount} instances from the
     * datasource.
     *
     * @return          the resulting list with the accounts.
     */
    List<JointAccount> getAll();


    /**
     * Updates the balance of an {@link JointAccount}.
     *
     * @param jointAccount  the target account.
     * @param newBalance    the new balance of the {@link JointAccount}
     *                      to update with.
     */
    void updateBalance(JointAccount jointAccount, double newBalance);


    /**
     * Checks if a {@link JointAccount} already exists based on the
     * given iban.
     *
     * @param iban      the joint account's iban needed for the check
     *                  to be made.
     * @return          true, if the joint account already exists,
     *                  false, otherwise.
     */
    boolean ibanNotExist(String iban);


    /**
     * Checks if the given ssn belongs to a specific
     * {@link JointAccount} based on the given iban.
     *
     * @param iban      the given iban for the target joint account.
     * @param ssn       the given ssn to validate.
     * @return          true, if the given ssn belongs to the
     *                  specific account, false, otherwise.
     */
    boolean isSsnValid(String iban, String ssn);
}
