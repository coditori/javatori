package com.massoudafrashteh.code.hibernate.util;

import com.massoudafrashteh.code.hibernate.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Massoud Afrashteh on 9/20/17.
 */
public class Utils {

    private Utils() {}

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
//        configuration.addResource("customer.hbm.xml");
        configuration.addAnnotatedClass(com.massoudafrashteh.code.hibernate.model.User.class);
        return configuration.buildSessionFactory();
    }
}
