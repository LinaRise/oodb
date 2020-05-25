package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.domain.Author;
import ru.icmit.oodb.lab12.domain.BookInfo;
import ru.icmit.oodb.lab12.domain.Sectionstitles;
import ru.icmit.oodb.lab12.repository.AuthorRepository;
import ru.icmit.oodb.lab12.repository.BookRepository;
import ru.icmit.oodb.lab12.repository.SectionRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController {

  @Autowired
  AuthorRepository authorRepository;

  @Autowired
  SectionRepository sectionRepository;

  @Autowired
  BookRepository bookRepository;




  @RequestMapping("/search")
  public String delObject(HttpServletRequest request,
                          @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    return "/search";
  }


  @RequestMapping("/authorbylastname")
  public String authorByLastName(HttpServletRequest request,
                                 @RequestParam("lastname") String lastname,
                                 @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);
    System.out.println("lastname = "+lastname);

    if (lastname!=null){
      List<Author> authors = authorRepository.findByLastName(lastname);

      model.addAttribute("authors", authors);
    }

//    System.out.println("lastname " + lastname);
//    Author author = repository.findByName(lastname);
//
//    System.out.println(author);

//    model.addAttribute("author", author);

    return "/authorbylastname";
  }


  @RequestMapping("/sectionbytitle")
  public String sectionByTitle(HttpServletRequest request,
                               @RequestParam("title") String title,
                               @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    System.out.println("title " + title);
    Sectionstitles section = sectionRepository.findByName(title);

    System.out.println(section);

    model.addAttribute("section", section);

    return "/sectionbytitle";

  }



  @RequestMapping("/bookbytitle")
  public String clientByName(HttpServletRequest request,
                             @RequestParam(value = "title", required = false) String title,
                             @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);
    System.out.println("title = "+title);

    if (title != null) {

      List<BookInfo> books = bookRepository.findByTitleBooks(title);
      System.out.println("Найденные книги = " + books);

      model.addAttribute("books", books);
    }

    return "/bookbytitle";
  }




}
