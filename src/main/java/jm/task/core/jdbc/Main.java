package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {
        // implement algorithm here
       userService.createUsersTable();
       userService.saveUser("Alex", "Sam", (byte)20);
        userService.saveUser("Alex1", "Sam1", (byte)20);
        userService.saveUser("Alex2", "Sam2", (byte)20);
        userService.saveUser("Alex3", "Sam3", (byte)20);

        userService.cleanUsersTable();

        userService.dropUsersTable();
                }
            }



