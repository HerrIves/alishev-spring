package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import utils.BookValidator;

import dao.BookDAO;
import models.Book;


@Controller
@RequestMapping("/books")
public class BookController {
    private BookDAO bookDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.bookValidator = bookValidator;
    }

    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "/book/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id")int id){
        model.addAttribute("book", bookDAO.show(id));
        return "/book/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("person") Book book){
        return "book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book")@Valid Book book,
                         BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "book/new";

        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute(bookDAO.show(id));
        return "book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book")@Valid Book book, @PathVariable("id")int id,
                         BindingResult bindingResult){

        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "book/edit";

        bookDAO.update(id, book);
        return "redirect:books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }


}

