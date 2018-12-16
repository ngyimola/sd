package dao;

import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements IUserDAO {

    private static final Log LOGGER = LogFactory.getLog(UserDAO.class);

    private SessionFactory factory;

    public UserDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public User loginUser(String username, String password) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username = :username AND password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            users = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    public User getUser(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE id = :id");
            query.setParameter("id", id);
            users = (List<User>)query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    public User addUser(User user) {
        int id = -1;
        Session session = factory.openSession();
        Transaction tx = null;
        User n = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(user);
            n = getUser(id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return n;
    }

    public List<User> getAllUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return users;
    }

    public void dummyOp(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(new User("a", "a", (byte) 0));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
    }

}
