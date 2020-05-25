package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.domain.Sectionstitles;
import ru.icmit.oodb.lab12.repository.SectionRepository;

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




  @RequestMapping("/addsection")
  public String sectionByTitle(HttpServletRequest request,
                               @RequestParam(value = "id", required = false) Long id,
                               @RequestParam(value = "title", required = false) String title,
                               @ModelAttribute("model") ModelMap model) {

    String path = request.getContextPath();
    model.addAttribute("app_path", path);

    Sectionstitles sectionstitles = null;
    // Если получили непустой id - пытаемся найти
    if (id != null) {
      sectionstitles = repository.findById(id);
    }

    if (sectionstitles == null) {
      sectionstitles = new Sectionstitles();
    }

    if (title!=null) {
      // Используем параметры формы
      sectionstitles.setTitle(title);


      sectionstitles = repository.save(sectionstitles);
    }


    model.addAttribute("section", sectionstitles);

    return "/section";
  }




}