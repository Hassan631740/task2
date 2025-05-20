package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl nameDao = new UserDaoJDBCImpl();
    public void createUsersTable() {
        nameDao .createUsersTable();

    }

    public void dropUsersTable() {
        nameDao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        nameDao.saveUser(name, lastName, age);
        //test123

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
