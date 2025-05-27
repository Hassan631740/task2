package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserHibernateDaoImpl;
import jm.task.core.jdbc.model.User;


import java.util.ArrayList;
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

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(); // Return empty list instead of null
    }

    public void cleanUsersTable() {
        nameDao.cleanUsersTable();

    }
}
