package com.massoudafrashteh.code.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Massoud Afrashteh on 9/20/17.
 */
public class Utils {

    private Utils() {}

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addResource("customer.hbm.xml");
//        configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }
}
