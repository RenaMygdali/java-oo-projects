package gr.aueb.cf.OOProjects.ch18_accounts_big.dao;

import gr.aueb.cf.OOProjects.ch18_accounts_big.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements IUserDAO {
    private static final List<User> users = new ArrayList<>();

    @Override
    public User insert(User user){
        users.add(user);
        return user;
    }

    @Override
    public User update(User oldUser, User newUser) {
        users.set(users.indexOf(oldUser), newUser);
        return newUser;
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));

    }

    @Override
    public void deleteBySsn(String ssn) {
        users.removeIf(user -> user.getSsn().equals(ssn));

    }

    @Override
    public User getById(Long id) {
        Optional<User> user = users.stream()
                .filter(usr -> usr.getId().equals(id))
                .findFirst();

        return user.orElse(null);
    }

    @Override
    public User getBySsn(String ssn) {
        Optional<User> user = users.stream()
                .filter(usr -> usr.getSsn().equals(ssn))
                .findFirst();

        return user.orElse(null);
    }

    @Override
    public boolean ssnNotExist(String ssn) {
        return users.stream()
                .noneMatch(acc -> acc.getSsn().equals(ssn));
    }
}
