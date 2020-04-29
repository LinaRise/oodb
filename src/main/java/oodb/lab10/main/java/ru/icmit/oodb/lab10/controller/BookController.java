package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Author;
import ru.icmit.oodb.lab10.domain.Book;
import ru.icmit.oodb.lab10.repository.AuthorRepository;
import ru.icmit.oodb.lab10.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class BookController {

  @Autowired
  private BookRepository repository;

  @RequestMapping("/book")
  public String books(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    List<Book> books = repository.findAll();

    model.addAttribute("books", books);

    return "/books";
  }

  @RequestMapping("/bookbytitle")
  public String bookbytitle(HttpServletRequest request,
                                 @RequestParam("title") String title,
                                 @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    System.out.println("title " + title);
    Book book = repository.findByTitle(title);

    System.out.println(book);

    model.addAttribute("book", book);

    return "/bookbytitle";
  }



}
