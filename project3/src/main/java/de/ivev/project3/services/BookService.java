package de.ivev.project3.services;

import de.ivev.project3.models.Book;
import de.ivev.project3.models.Person;
import de.ivev.project3.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.findById(id).get();
    }

    public void saveBook(Book book) {

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
