package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person oldOwner = session.get(Person.class, 3);
            Person newOwner = session.get(Person.class, 2);

            List<Item> items = oldOwner.getItems();
            items.forEach(item -> item.setOwner(newOwner));

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
