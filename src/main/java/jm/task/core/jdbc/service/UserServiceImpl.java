package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;

import jm.task.core.jdbc.dao.UserHibernateDaoImpl;
import jm.task.core.jdbc.model.User;


import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserHibernateDaoImpl nameDao = new UserHibernateDaoImpl();
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
        List<User> allUser = nameDao.getAllUsers();
        for (User user: allUser) {
            System.out.println(user);
        }
        return allUser;
    }

    public void cleanUsersTable() {
        nameDao.cleanUsersTable();

    }
}
