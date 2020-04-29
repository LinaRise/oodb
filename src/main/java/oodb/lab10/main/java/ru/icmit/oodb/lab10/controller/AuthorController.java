package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Author;
import ru.icmit.oodb.lab10.repository.AuthorRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository repository;



    @RequestMapping("/author")
    public String authors(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<Author> authors = repository.findAll();

        model.addAttribute("authors", authors);

        return "/authors";
    }

    @RequestMapping("/authorbylastname")
    public String authorByLastName(HttpServletRequest request,
                               @RequestParam("lastname") String lastname,
                               @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        System.out.println("lastname " + lastname);
        Author author = repository.findByName(lastname);

        System.out.println(author);

        model.addAttribute("author", author);

        return "/authorbylastname";
    }



}
