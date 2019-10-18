package DAO;

import util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;


public abstract class DAOImple<T> {

    public void save(T accountEntity) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(accountEntity);
        session.getTransaction().commit();
        session.close();
    }

    public abstract Boolean containsUsername(String username);

    public abstract T getAccountByUsername(String username);

    public abstract List<String> getAllUsers();
}