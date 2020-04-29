package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Author;
import ru.icmit.oodb.lab10.domain.Sectionstitles;
import ru.icmit.oodb.lab10.repository.AuthorRepository;
import ru.icmit.oodb.lab10.repository.SectionRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SectionController {
  @Autowired
  private SectionRepository repository;

  @RequestMapping("/section")
  public String sections(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    List<Sectionstitles> sections = repository.findAll();

    model.addAttribute("sections", sections);

    return "/sections";
  }

  @RequestMapping("/sectionbytitle")
  public String sectionByTitle(HttpServletRequest request,
                                 @RequestParam("title") String title,
                                 @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();

    model.addAttribute("app_path", path);


    System.out.println("title " + title);
    Sectionstitles section = repository.findByName(title);

    System.out.println(section);

    model.addAttribute("section", section);

    return "/sectionbytitle";

  }
}