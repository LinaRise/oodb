package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.icmit.oodb.lab12.repository.AuthorRepository;
import ru.icmit.oodb.lab12.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;
    @RequestMapping("/")
    public String index(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        return "/index";
    }

}
