package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.repository.AuthorRepository;
import ru.icmit.oodb.lab12.repository.BookRepository;
import ru.icmit.oodb.lab12.repository.SectionRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeleteObjectController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/author/delete")
    public String deleteAuthor(HttpServletRequest request,
                          @RequestParam("authorid") Long authorid,
                          @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        authorRepository.removeAuthor(authorid);
        return "/delobject";
    }


    @RequestMapping("/section/delete")
    public String deleteSection(HttpServletRequest request,
                               @RequestParam("sectionid") Long sectionid,
                               @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        sectionRepository.removeSection(sectionid);

        return "/delobject";
    }


    @RequestMapping("/author/deletebook")
    public String deleteBook(HttpServletRequest request,
                                @RequestParam("bookid") Long bookid,
                                @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

//        authorRepository.removeAuthorBook(bookid);
        bookRepository.removeBook(bookid);

        return "/delobject";
    }

    @RequestMapping("/author/deleteallbooks")
    public String deleteAllAccounts(HttpServletRequest request,
                                @RequestParam("authorid") Long authorid,
                                @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        authorRepository.removeAuthorBooks(authorid);
        return "/delobject";
    }

    @RequestMapping("/delobject")
    public String delObject(HttpServletRequest request,
                            @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        return "/delobject";
    }


}
