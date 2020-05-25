package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.domain.Author;
import ru.icmit.oodb.lab12.domain.Book;
import ru.icmit.oodb.lab12.repository.AuthorRepository;
import ru.icmit.oodb.lab12.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AuthorController {

  @Autowired
  private AuthorRepository repository;

  @Autowired
  private BookRepository bookRepository;

  @RequestMapping("/author")
  public String authors(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    List<Author> authors = repository.findAll();

    model.addAttribute("authors", authors);

    return "/authors";
  }




  @RequestMapping("/addauthor")
  @Transactional
  public String authorByLastName(HttpServletRequest request,
                                 @RequestParam(value = "id", required = false) Long id,
                                 @RequestParam(value = "lastname", required = false) String lastname,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "patronymic", required = false) String patronymic,
                                 @RequestParam(value = "info", required = false) String info,
                                 @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();
    model.addAttribute("app_path", path);

    Author author = null;
    // Если получили непустой id - пытаемся найти
    if (id != null) {
      author = repository.getFetchAuthor(id);
//      author = repository.findById(id);
      System.out.println("Непустой id автор = " + author);
    }

    if (author == null) {
      author = new Author();
      System.out.println("пустой id новый автор = " + author);
    }

    if (lastname != null || name != null) {
      // Используем параметры формы
      author.setLastname(lastname);
      author.setName(name);
      author.setPatronymic(patronymic);
      author.setInfo(info);
      author = repository.save(author);
      System.out.println(" Сохранение автора");
    }

    // Запросим теперь список всех счетов клиента (если клиент есть в базе)
    if (author.getId() != null) {
//      List<Book> books = author.getBook();//repository.getAuthorBooks(author);
      List<Book> books = repository.getAuthorBooks(author);
      if (books != null) {
        // Передаем в параметры веб-страницы
        model.addAttribute("books", books);
        System.out.println("Сппиок книга автора");
      }
    }
    System.out.println(author.getId() + "!!!!!!!!");
    model.addAttribute("author", author);

    return "/author";
  }


  @RequestMapping("/deletebook")
  @Transactional
  public String deleteAllBooks(HttpServletRequest request,
                               @RequestParam("id") Long id,
                               @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);

    Author author = repository.findByBookId(id);
    System.out.println(author);

    repository.removeBook(id);

    if (author != null && author.getId() != null) {
      List<Book> books = repository.getAuthorBooks(author);

      model.addAttribute("books", books);
    }

    model.addAttribute("author", author);
    return "/author";
  }

}
