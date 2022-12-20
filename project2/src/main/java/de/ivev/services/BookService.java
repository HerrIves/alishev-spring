package de.ivev.services;

import de.ivev.models.Book;
import de.ivev.models.Person;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository;

    public List<Book> findAll() {
        return null;
    }

    public Book findOne(int id) {

    }

    public void savePerson(Book book) {

    }

    public void updateBook(int id, Book book) {

    }

    public void deleteBook(int id) {

    }

    public void releaseBook(int id) {
    }

    public void assign(int id, Person selectedPerson) {

    }
}
