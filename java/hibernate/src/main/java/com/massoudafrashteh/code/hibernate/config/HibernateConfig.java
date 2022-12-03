package com.massoudafrashteh.code.hibernate.config;

import com.massoudafrashteh.code.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Massoud Afrashteh on 9/20/17.
 */
public class HibernateConfig {

    private static final SessionFactory session = getSessionFactory();

    private HibernateConfig() {}

    public static SessionFactory getSession() {
        System.out.println("session = " + session);
        return session;
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}
