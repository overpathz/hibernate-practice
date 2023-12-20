package org.pathz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        Query<Employee> selectEFromEmployeeE =
                session1.createQuery("select c from Company c WHERE size(c.employees) < 10", Employee.class);
        List<Employee> list = selectEFromEmployeeE.list();
        System.out.println(list);

        session1.getTransaction().commit();

        sessionFactory.close();
    }
}
