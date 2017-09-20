package com.massoudafrashteh.code.hibernate.config;

import com.massoudafrashteh.code.hibernate.util.Utils;
import org.hibernate.Session;

/**
 * Created by Massoud Afrashteh on 9/20/17.
 */
public class HibernateConfig {

    private static final Session session = Utils.getSessionFactory().openSession();

    private HibernateConfig() {}

    public static Session getSession() {
        return session;
    }
}
