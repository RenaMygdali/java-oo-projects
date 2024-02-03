package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.User;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.UserInsertDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.UserUpdateDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.UserNotFoundException;

public interface IUserService {


    /**
     * Creates a new bank {@link User} based on the
     * data carried by the {@link UserInsertDTO}.
     *
     * @param dto       the {@link UserInsertDTO} object that contains
     *                  the {@link User} data to be inserted.
     * @return          the resulting {@link User}.
     */
    User insertUser(UserInsertDTO dto);


    /**
     * Updates the bank's {@link User} details based on the
     * data carried by the {@link UserUpdateDTO}.
     *
     * @param oldDTO    the {@link UserUpdateDTO} object that contains the
     *                  {@link User} data to be updated.
     * @param newDTO    the {@link UserUpdateDTO} object that contains
     *                  the {@link User} data to update with.
     * @return          the resulting {@link User}.
     * @throws
     *      UserNotFoundException
     */
    User updateUser(UserUpdateDTO oldDTO, UserUpdateDTO newDTO) throws UserNotFoundException;



    /**
     * Removes an existing {@link User}.
     *
     * @param id        the {@link User} id needed for the user
     *                  to be removed.
     * @throws
     *      UserNotFoundException
     */
    void deleteUserById(Long id) throws UserNotFoundException;



    /**
     * Removes an existing {@link User}.
     *
     * @param ssn   the {@link User} ssn needed for the user
     *              to be removed.
     * @throws
     *      UserNotFoundException
     */
    void deleteUserBySsn(String ssn) throws UserNotFoundException;


    /**
     * Returns a specific {@link User} instance based
     * on the given id.
     *
     * @param id        the given id.
     * @return          the resulting {@link User}.
     * @throws
     *      UserNotFoundException
     */
    User getUserById(Long id) throws UserNotFoundException;


    /**
     * Returns a specific {@link User} instance based
     * on the given ssn.
     *
     * @param ssn       the given ssn.
     * @return          the resulting {@link User}.
     * @throws
     *      UserNotFoundException
     */
    User getUserBySsn(Long ssn) throws UserNotFoundException;
}
