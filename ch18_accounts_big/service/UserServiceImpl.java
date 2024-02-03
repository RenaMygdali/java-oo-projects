package gr.aueb.cf.OOProjects.ch18_accounts_big.service;

import gr.aueb.cf.OOProjects.ch18_accounts_big.dao.IUserDAO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.model.User;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.UserInsertDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.dto.UserUpdateDTO;
import gr.aueb.cf.OOProjects.ch18_accounts_big.service.exceptions.UserNotFoundException;

public class UserServiceImpl implements IUserService {
    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User insertUser(UserInsertDTO dto) {
        if (dto == null) return null;
        User user = null;

        user = mapUserByInsert(dto);
        return userDAO.insert(user);

    }

    @Override
    public User updateUser(UserUpdateDTO oldDTO, UserUpdateDTO newDTO) throws UserNotFoundException {
        if (oldDTO == null || newDTO == null) return null;
        User oldUser;
        User newUser;

        try {
            oldUser = mapUserByUpdate(oldDTO);
            newUser = mapUserByUpdate(newDTO);

            if (userDAO.ssnNotExist(oldUser.getSsn())) {
                throw new UserNotFoundException("User not found");
            }
            return userDAO.update(oldUser, newUser);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        if (id == null) return;

        try {
            if (userDAO.getById(id) == null) {
                throw new UserNotFoundException("User not found");
            }
            userDAO.deleteById(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUserBySsn(String ssn) throws UserNotFoundException {

        if (ssn == null) return;

        try {
            if (userDAO.getBySsn(ssn) == null) {
                throw new UserNotFoundException("User not found");
            }
            userDAO.deleteBySsn(ssn);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        if (id == null) return null;

        User user;

        try {
            user = userDAO.getById(id);

            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
            return user;
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User getUserBySsn(Long ssn) throws UserNotFoundException {
        if (ssn == null) return null;

        User user;

        try {
            user = userDAO.getById(ssn);

            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
            return user;
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

    }


    private User mapUserByInsert(UserInsertDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }

    private User mapUserByUpdate(UserUpdateDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }
}
