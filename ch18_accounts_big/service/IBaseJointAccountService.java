package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.JointAccountInsertDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.JointAccountUpdateDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.JointAccount;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.NegativeAmountException;

import java.util.List;

public interface IBaseJointAccountService {

    /**
     * Creates a new {@link JointAccount} based on
     * the data carried by the {@link JointAccountInsertDTO}
     *
     * @param dto  the {@link JointAccountInsertDTO} object
     *             that contains the {@link JointAccount} data.
     * @return     the resulting {@link JointAccount}.
     */
    JointAccount insertJointAccount(JointAccountInsertDTO dto);


    /**
     * Updates an existing {@link JointAccount} based on the
     * data carried by the {@link JointAccountUpdateDTO}.
     *
     * @param oldDTO        the DTO object with the data to be updated.
     * @param newDTO        the DTO object with the data to update with.
     * @return              the new {@link JointAccount}.
     * @throws
     *      AccountNotFoundException
     */
    JointAccount updateJointAccount(JointAccountUpdateDTO oldDTO, JointAccountUpdateDTO newDTO) throws AccountNotFoundException;


    /**
     * Removes an existing {@link JointAccount}.
     *
     * @param iban      the {@link JointAccount} iban needed
     *                  for the joint account to be removed.
     * @throws
     *      AccountNotFoundException
     */
    void deleteJointAccountByIban(String iban) throws AccountNotFoundException;


    /**
     * Returns a specific {@link JointAccount}.
     *
     * @param iban      the {@link JointAccount} iban needed
     *                  for the joint account to be returned.
     * @return          the specific {@link JointAccount}.
     * @throws
     *      AccountNotFoundException
     */
    JointAccount getJointAccountByIban(String iban) throws AccountNotFoundException;


    /**
     * Returns all the {@link JointAccount} instances
     * from the datasource.
     *
     * @return      a list with all the joint accounts.
     */
    List<JointAccount> getAllJoinAccounts();

    /**
     * Deposits a certain amount of money into an {@link JointAccount},
     * thus increasing the balance of the joint account.
     *
     * @param iban          the {@link JointAccount} iban needed for the
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
