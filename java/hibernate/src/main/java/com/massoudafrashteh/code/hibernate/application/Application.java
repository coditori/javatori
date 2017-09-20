package com.massoudafrashteh.code.hibernate.application;


import com.massoudafrashteh.code.hibernate.config.HibernateConfig;
import com.massoudafrashteh.code.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Massoud Afrashteh on 9/18/17.
 */
public class Application {

    public static void main(String[] args) {

        Session session = HibernateConfig.getSession();
        Transaction tx=session.getTransaction();

        User user = new User();
        user.setName("Massoud");

        tx.begin();
        session.save(user);
        tx.commit();

        session.close();
        System.out.println("Data is saved :)");
    }

}
