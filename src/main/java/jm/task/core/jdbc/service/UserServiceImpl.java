package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserHibernateDaoImpl;
import jm.task.core.jdbc.model.User;


import java.util.ArrayList;
import java.util.List;

public abstract class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserHibernateDaoImpl();

    // All service methods use userDao now...
}
