package com.massoudafrashteh.code.hibernate;


import com.massoudafrashteh.code.hibernate.config.HibernateConfig;
import com.massoudafrashteh.code.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.logging.Logger;


/**
 * Created by Massoud Afrashteh on 9/18/17.
 */
public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        User user = new User();
        user.setFirstName("Ario2");
        SessionFactory factory = HibernateConfig.getSession();
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void read() {
        SessionFactory factory = HibernateConfig.getSession();
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            User user = session.find(User.class, 1L);
            System.out.println("found user = " + user);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}