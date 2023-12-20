package org.pathz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        List<Employee> selectEFromEmployeeE = session1.createQuery("select e from Employee e where e.workedAt between :startDate and :endDate", Employee.class)
                .setParameter("startDate", LocalDateTime.now())
                .setParameter("endDate", LocalDateTime.now().plus(1, ChronoUnit.DAYS))
                .list();

        System.out.println(selectEFromEmployeeE);

        session1.getTransaction().commit();

        sessionFactory.close();
    }
}