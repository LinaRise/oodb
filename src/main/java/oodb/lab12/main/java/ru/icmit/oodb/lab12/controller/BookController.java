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
import ru.icmit.oodb.lab12.domain.Sectionstitles;
import ru.icmit.oodb.lab12.repository.AuthorRepository;
import ru.icmit.oodb.lab12.repository.BookRepository;
import ru.icmit.oodb.lab12.repository.SectionRepository;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private SectionRepository sectionRepository;

  @RequestMapping("/book")
  public String books(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    List<Book> books = bookRepository.findAll();

    model.addAttribute("books", books);

    return "/books";
  }


  @RequestMapping("/addbook")
  @Transactional
  public String authorByLastName(HttpServletRequest request,
                                 @RequestParam(value = "id", required = false) Long id,
                                 @RequestParam(value = "title", required = false) String title,
                                 @RequestParam(value = "UDC", required = false) String UDC,
                                 @RequestParam(value = "LBC", required = false) String LBC,
                                 @RequestParam(value = "price", required = false) Double price,
                                 @RequestParam(value = "dateofpublishing", required = false) String dateofpublishing,
                                 @RequestParam(value = "sectionstitles_id", required = false) Long sectionstitles_id,
                                 @ModelAttribute("model") ModelMap model) {
    System.out.println("зашли");
    String path = request.getContextPath();
    model.addAttribute("app_path", path);
    System.out.println("id = " + id);
    System.out.println("sectionstitles_id = " + sectionstitles_id);
    Author author = null;
    Sectionstitles sectionstitle = null;
    // Если получили непустой id - пытаемся найти клиента к которому надо привязать счет
    if (id != null) {
      author = authorRepository.getFetchAuthor(id);
//      author = authorRepository.findById(id);
      System.out.println("Найденный автор = " + author);
      if (sectionstitles_id != null)
        sectionstitle = sectionRepository.getFetchSection(sectionstitles_id);
//      sectionstitle = sectionRepository.findById(sectionstitles_id);
      System.out.println("Найденная секция = " + sectionstitle);

      if (author != null) {
        Book book = new Book();
        book.setTitle(title);
        book.setUDC(UDC);
        book.setLBC(LBC);
        book.setPrice(price);
        try {
          book.setDateofpublishing(new SimpleDateFormat("yyyy-MM-dd").parse(dateofpublishing));
        } catch (ParseException e) {
          e.printStackTrace();
        }
        book.setSectionstitles(sectionstitle);
        book.setAuthor(author);
        bookRepository.save(book);
        System.out.println("Сохранили книгу");
        author.getBook().add(book);
        if(sectionstitle!=null){
          sectionstitle.getBooks().add(book);
          sectionRepository.save(sectionstitle);
        }


        authorRepository.save(author);
        System.out.println("Сохранили автора");


      }

      // Запросим теперь список всех книг автора
      List<Book> books = authorRepository.getAuthorBooks(author);
      // Передаем в параметры веб-страницы
      model.addAttribute("books", books);

    } else {
      author = new Author();
    }

    model.addAttribute("author", author);
    model.addAttribute("section", sectionstitle);

    return "/author";
  }


  @RequestMapping("/editbook")
  @Transactional
  public String editBook(HttpServletRequest request,
                         @RequestParam(value = "id", required = false) Long id,
                         @RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "UDC", required = false) String UDC,
                         @RequestParam(value = "LBC", required = false) String LBC,
                         @RequestParam(value = "price", required = false) Double price,
                         @RequestParam(value = "dateofpublishing", required = false) String dateofpublishing,
                         @RequestParam(value = "sectionstitles_id", required = false) Long sectionstitles_id,
                         @RequestParam(value = "author_id", required = false) Long author_id,
                         @ModelAttribute("model") ModelMap model) {
    String path = request.getContextPath();
    model.addAttribute("app_path", path);
    Book book = null;
    Sectionstitles sectionstitles = null;
    Author author = null;


    // Если получили непустой id - пытаемся найти книгу
    if (id != null) {
      book = bookRepository.findById(id);
      System.out.println("book!!!" + book);
      System.out.println("id!!!" + id);
      System.out.println("bookid!!!" + book.getId());


      if (sectionstitles_id != null)
        sectionstitles = sectionRepository.getFetchSection(sectionstitles_id);
      System.out.println("sectionstitles!!!" + sectionstitles);


      System.out.println("author_id!!! = " + author_id);
      if (author_id != null)
        author = authorRepository.getFetchAuthor(author_id);

      // Если нашли книгу - добавляем
      if (book != null && author != null) {
        book.setTitle(title);
        book.setUDC(UDC);
        book.setLBC(LBC);
        book.setPrice(price);

        book.setSectionstitles(sectionstitles);

        try {
          book.setDateofpublishing(new SimpleDateFormat("yyyy-MM-dd").parse(dateofpublishing));
        } catch (ParseException e) {
          e.printStackTrace();
        }


        book.setAuthor(author);
        System.out.println("getId" + book.getId());
        bookRepository.save(book);
        System.out.println("Сохранили книгу");
        author.getBook().add(book);


        sectionRepository.save(sectionstitles);


        authorRepository.save(author);
      }


      // Передаем в параметры веб-страницы
      model.addAttribute("author", author);
      model.addAttribute("section", sectionstitles);
      model.addAttribute("book", book);

    }

//    model.addAttribute("author", author);
//    model.addAttribute("section", sectionstitles);

    return "/book";
  }


}
