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
        Person person1 = new Person("mike", 20);
        Person person3 = new Person("fike", 40);

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Person.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(person1);
        session.save(person3);

        session.getTransaction().commit();
        sessionFactory.close();

    }
}
