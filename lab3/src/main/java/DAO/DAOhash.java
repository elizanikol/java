package DAO;

import entities.HashEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;


public class DAOhash extends DAOImple{

    public Boolean containsUsername(String username) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<HashEntity> list=session.createQuery("from HashEntity").list();
        session.getTransaction().commit();
        session.close();
        for (HashEntity account : list) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public HashEntity getAccountByUsername(String username){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from HashEntity where username=:username");
        query.setString("username", username);
        HashEntity accountEntity= (HashEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return accountEntity;
    }

    public List<String> getAllUsers() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<String> users = new ArrayList<>();
        List<HashEntity> list=session.createQuery("from HashEntity").list();
        for (HashEntity account : list) {
            users.add(account.getUsername());
        }
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public Boolean containsHash(String hash) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<HashEntity> list=session.createQuery("from HashEntity").list();
        session.getTransaction().commit();
        session.close();
        for (HashEntity account : list) {
            if (account.getHash().equals(hash)) {
                return true;
            }
        }
        return false;
    }
}
