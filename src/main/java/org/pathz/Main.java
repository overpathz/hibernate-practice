package org.pathz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        Company company = session1.get(Company.class, 1L);
        session1.remove(company);

        session1.getTransaction().commit();

        sessionFactory.close();
    }
}