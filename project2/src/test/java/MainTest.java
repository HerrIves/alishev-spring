import de.ivev.models.Book;
import de.ivev.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MainTest {
    Configuration configuration;
    SessionFactory sessionFactory;
    @Before
    public void before(){
        configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Book.class);

        sessionFactory = configuration.buildSessionFactory();
    }
    @Test
    public void mainTest(){
        try(
                Session session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            Book book = session.get(Book.class, 2);

            Assert.assertEquals("java filosofy", book.getTitle());
        }
    }
}
