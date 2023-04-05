package lk.ijse.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FactoryConfiguration {
    private static FactoryConfiguration fc;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration();/*.configure().addAnnotatedClass(Item.class);*/
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        configuration.addAnnotatedClass(Student.class).addAnnotatedClass(Program.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);


    }

    public static FactoryConfiguration getInstance() {
        return (fc == null) ? fc = new FactoryConfiguration() : fc;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
