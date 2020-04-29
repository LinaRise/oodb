package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Sectionstitles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class SectionRepository {
  @PersistenceContext(name = "entityManagerFactory")
  protected EntityManager entityManager;

  public List<Sectionstitles> findAll() {

    Query query = entityManager.createQuery("select a from Sectionstitles a", Sectionstitles.class);


    List<Sectionstitles> sectionstitles = query.getResultList();

    return sectionstitles;

  }

  public Sectionstitles findByName(String title) {
    Query query = entityManager.createQuery(
            "select a from Sectionstitles a where a.title like :title ", Sectionstitles.class);

    query.setParameter("title", title);
    List<Sectionstitles> sectionstitles = query.getResultList();

    Sectionstitles section = (sectionstitles != null && sectionstitles.size() > 0) ? sectionstitles.get(0) : null;


    return section;
  }

}