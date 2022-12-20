package de.ivev.services;

import de.ivev.models.Book;
import de.ivev.models.Person;
import de.ivev.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return null;
    }

    public Book findOne(int id) {
        return bookRepository.findById(id).get();
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
