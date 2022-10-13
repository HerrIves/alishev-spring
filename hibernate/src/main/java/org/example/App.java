package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Movie movie;
        Actor actor;


        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
/*
            Actor actor = new Actor("Jonny Depp", 55);
            Actor actor1 = new Actor("Nobody", 66);
            Movie movie = new Movie("Deadman", 1988);

            actor.setMovies(List.of(movie));
            actor1.setMovies(List.of(movie));
            movie.setActors(List.of(actor, actor1));

            session.save(actor);
            session.save(actor1);
            session.save(movie);

            Movie movie = new Movie("Alice in Dreamland", 2008);
            Actor actor = session.get(Actor.class, 1);

            movie.setActors(List.of(actor));
            actor.getMovies().add(movie);
            session.save(movie);
*/
            movie = session.get(Movie.class, 1);
            actor = session.get(Actor.class, 1);
            System.out.println(movie);
            System.out.println(movie.getActors().contains(actor));

            actor.getMovies().remove(movie);
            movie.getActors().remove(actor);

            session.getTransaction().commit();

        }
        System.out.println(actor.getMovies());
        System.out.println(movie.getActors());

    }
}
