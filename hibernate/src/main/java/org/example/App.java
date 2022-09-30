package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Person.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Person person = session.get(Person.class, 1);
        System.out.println(person);

        session.getTransaction().commit();
        sessionFactory.close();

    }
}
