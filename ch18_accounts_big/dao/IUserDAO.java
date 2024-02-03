package gr.aueb.cf.OOProjects.ch18_accounts_big.dao;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.User;

public interface IUserDAO {


    /**
     * Creates a new {@link User} in the datasource.
     *
     * @param user      the model object that contains the user's data.
     * @return          the resulting {@link User}.
     */
    User insert(User user);



    /**
     * Updates an existing {@link User} instance.
     *
     * @param oldUser       the {@link User} instance to be updated.
     * @param newUser       the {@link User} instance to update with.
     * @return              the new {@link User} instance.
     */
    User update(User oldUser, User newUser);


    /**
     * Removes an existing {@link User}.
     *
     * @param id        the {@link User} id needed for the user
     *                  to be removed.
     */
    void deleteById(Long id);


    /**
     * Removes an existing {@link User}.
     *
     * @param ssn       the {@link User} ssn needed for the
     *                  user to be removed.
     */
    void deleteBySsn(String ssn);


    /**
     * Returns an existing {@link User} based on the given
     * id.
     *
     * @param id        the {@link User} id needed for the
     *                  user to be returned.
     * @return          the corresponding {@link User}.
     */
    User getById(Long id);



    /**
     * Returns an existing {@link User} based on the given
     * ssn.
     *
     * @param ssn       the {@link User} ssn needed for the
     *                  user to be returned.
     * @return          the corresponding {@link User}.
     */
    User getBySsn(String ssn);


    /**
     * Checks if an {@link User} already exists based on the
     * given ssn.
     *
     * @param ssn      the user's ssn needed for the check
     *                 to be made.
     * @return         true, if the user already exists,
     *                 false, otherwise.
     */
    boolean ssnNotExist(String ssn);
}