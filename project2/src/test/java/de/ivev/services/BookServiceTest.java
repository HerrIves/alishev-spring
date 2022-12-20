package de.ivev.services;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookService();




    @Test
    public void findAllTest() {
        assertTrue(false);
    }

    @Test
    public void findOneTest() {
        assertEquals("java 8", bookService.findOne(1).getTitle());
    }
}