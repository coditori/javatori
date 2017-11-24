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


// Create a customer entity
        Map<String, String> david = new HashMap<>();
        david.put( "name","David" );

// Create an organization entity
//        Map<String, String>foobar = new HashMap<>();
//        foobar.put( "name","Foobar Inc." );

// Link both
//        david.put( "organization", foobar.toString() );

// Save both
        tx.begin();
        s.save( "Customer",david );
//        s.save( "Organization",foobar );

        tx.commit();
        s.close();

//        User user = new User();
//        user.setName("Massoud");
//
//        tx.begin();
//        session.save(user);
//        tx.commit();
//
//        session.close();
//        System.out.println("Data is saved :)");
    }
}
