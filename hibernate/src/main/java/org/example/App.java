package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Pasha", 37);
            Passport passport = new Passport(777);
            person.setPassport(passport);
            session.save(person);
            session.getTransaction().commit();

/*
            Person person1 = session.get(Person.class, 5);
            person1.getPassport()
                    .setNumber(888);
            session.getTransaction().commit();

            Person person2 = session.get(Person.class, 5);
            session.delete(person2);
            session.getTransaction().commit();
*/

        } finally {
            sessionFactory.close();
        }


    }
}
