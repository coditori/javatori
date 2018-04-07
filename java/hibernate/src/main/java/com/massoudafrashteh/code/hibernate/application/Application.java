package com.massoudafrashteh.code.hibernate.application;


import com.massoudafrashteh.code.hibernate.config.HibernateConfig;
import com.massoudafrashteh.code.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Massoud Afrashteh on 9/18/17.
 */
public class Application {

    public static void main(String[] args) {

        Session s = HibernateConfig.getSession();
        Transaction tx= s.getTransaction();

        Map<String, String> david = new HashMap<>();
        david.put( "name","David" );

        tx.begin();

        s.save( "Customer",david );

        tx.commit();
        s.close();
    }
}
