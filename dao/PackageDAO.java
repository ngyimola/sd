package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entities.Package;

import java.util.List;

public class PackageDAO implements IPackageDAO {
    private static final Log LOGGER = LogFactory.getLog(PackageDAO.class);

    private SessionFactory factory;

    public PackageDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public List<Package> getAllPackages() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Package> packages = null;
        try {
            tx = session.beginTransaction();
            packages = session.createQuery("FROM Package").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return packages;
    }

    public Package getPackage(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Package> packages = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Package WHERE id = :id");
            query.setParameter("id", id);
            packages = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return packages != null && !packages.isEmpty() ? packages.get(0) : null;
    }

    public void updatePackage(Package pack) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Package oldPack = getPackage(pack.getId());
            /*oldPack.setName(pack.getName());
            oldPack.setDescription(pack.getDescription());
            oldPack.setDestinationCity(pack.getDestinationCity());
            oldPack.setTracking(pack.getTracking());
            oldPack.setPathsById(pack.getPathsById());
            oldPack.setUserByReceiver(pack.getUserByReceiver());
            oldPack.setUserBySender(pack.getUserBySender());*/
            oldPack. setTracking(pack.getTracking());
            session.update(oldPack);
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

    public void deletePackage(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Package oldPack = getPackage(id);
            session.delete(oldPack);
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

    public Package addPackage(Package pack) {
        int id = -1;
        Session session = factory.openSession();
        Transaction tx = null;
        Package p = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(pack);
            p = getPackage(id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.error("", e);
        } finally {
            session.close();
        }
        return p;
    }
}
