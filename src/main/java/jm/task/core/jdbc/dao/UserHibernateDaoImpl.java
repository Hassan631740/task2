package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.SystemException;

import java.util.List;

public class UserHibernateDaoImpl implements UserDao {

    @Override
    public void createUsersTable() throws SystemException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), lastName VARCHAR(50), age TINYINT)";
        executeSQL(sql);
    }

    @Override
    public void dropUsersTable() throws SystemException {
        String sql = "DROP TABLE IF EXISTS users";
        executeSQL(sql);
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SystemException {
        Transaction tx = null;
        try (Session session = (Session) util.Util.getSessionFactory().openSession()) {
            tx = (Transaction) session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction tx = null;
        try (Session session = util.Util.getSessionFactory().openSession()) {
            tx = (Transaction) session.beginTransaction();
            User user = ((org.hibernate.Session) session).get(User.class, id);
            if (user != null) ((org.hibernate.Session) session).delete(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = util.Util.getSessionFactory().openSession()) {
            return ((org.hibernate.Session) session).createQuery("FROM User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() throws SystemException {
        Transaction tx = null;
        try (Session session = (Session) util.Util.getSessionFactory().openSession()) {
            tx = (Transaction) session.beginTransaction();
            ((org.hibernate.Session) session).createQuery("DELETE FROM User").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    private void executeSQL(String sql) throws SystemException {
        Transaction tx = null;
        try (Session session = (Session) (Session) util.Util.getSessionFactory().openSession()) {
            tx = (Transaction) session.beginTransaction();
            ((org.hibernate.Session) session).createSQLQuery(sql).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}