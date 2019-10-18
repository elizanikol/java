package DAO;

import entities.PasswordEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;


public class DAOpassword extends DAOImple {

    public Boolean containsUsername(String username) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<PasswordEntity> list=session.createQuery("from PasswordEntity").list();
        session.getTransaction().commit();
        session.close();
        for (PasswordEntity account : list) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public PasswordEntity getAccountByUsername(String username){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from PasswordEntity where username=:username");
        query.setString("username", username);
        PasswordEntity accountEntity= (PasswordEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return accountEntity;
    }

    public List<String> getAllUsers() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<String> users = new ArrayList<>();
        List<PasswordEntity> list=session.createQuery("from PasswordEntity").list();
        for (PasswordEntity account : list) {
            users.add(account.getUsername());
        }
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public Boolean containsLoginPassword(String username, String password) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<PasswordEntity> list=session.createQuery("from PasswordEntity").list();
        session.getTransaction().commit();
        session.close();
        for (PasswordEntity account : list) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
