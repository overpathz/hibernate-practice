package org.pathz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inserter {
    public static void main(String[] args) throws SQLException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();


        Company google = session1.get(Company.class, 2L);

        for (int i = 0; i < 4; i++) {
            Employee employee = Employee.builder().firstName("OtherName" + i+1)
                    .lastname("OtherLastname" + i+1).build();
            google.addEmployee(employee);
        }

        session1.getTransaction().commit();

        sessionFactory.close();
    }
}