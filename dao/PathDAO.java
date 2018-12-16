package dao;

import entities.Path;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PathDAO implements IPathDAO {

    private static final Log LOGGER = LogFactory.getLog(PathDAO.class);

    private SessionFactory factory;

    public PathDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean addPath(Path path) {
        int id = -1;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(path);
            path.setId(id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return id > 0;
    }

    public Path getPath(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Path> paths = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Path WHERE id = :id");
            query.setParameter("id", id);
            paths = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return paths != null && !paths.isEmpty() ? paths.get(0) : null;
    }

    public List<Path> getAllPathsForPackage(int packageID) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Path> paths = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Path p WHERE p.packageByPackageId.id = :packageByPackageId");
            query.setParameter("packageByPackageId", packageID);
            paths = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return paths;
    }

    public void deletePath(Path path)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(path);
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
