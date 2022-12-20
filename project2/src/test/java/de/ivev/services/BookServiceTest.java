package de.ivev.services;

import de.ivev.repositories.BookRepository;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookServiceTest {
    BookRepository bookRepository;
    BookService bookService = new BookService(bookRepository);




    @Test
    public void findAllTest() {
        assertTrue(false);
    }

    @Test
    public void findOneTest() {
        assertEquals("java 8", bookService.findOne(1).getTitle());
    }
}