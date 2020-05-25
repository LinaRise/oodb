package ru.icmit.oodb.lab12.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icmit.oodb.lab12.domain.Book;
import ru.icmit.oodb.lab12.domain.Sectionstitles;

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

  public Sectionstitles findById(Long id) {
    return entityManager.find(Sectionstitles.class, id);
  }


  @Transactional
  public Sectionstitles save(Sectionstitles sectionstitles) {

    if (sectionstitles == null) return null;
    if (sectionstitles.getId() != null) {
      sectionstitles = entityManager.merge(sectionstitles);
    } else {
      entityManager.persist(sectionstitles);
    }
    return sectionstitles;
  }

  @Transactional
  public boolean removeSection(Long id) {
    Sectionstitles sectionstitles = entityManager.find(Sectionstitles.class, id);
    if (sectionstitles == null) return false;

    Query query = entityManager.createQuery(
            "select b from Book b where b.sectionstitles = :sectionstitles", Book.class);
    query.setParameter("sectionstitles", sectionstitles);
    List<Book> books = query.getResultList();

    for (Book book : books) {
      book.setSectionstitles(null);
    }


    entityManager.remove(sectionstitles);

    return true;


  }


  //(при работе с "ленивой" загрузкой коллекций)
  public Sectionstitles getFetchSection(Long id) {
    Sectionstitles sectionstitles = null;
    try {
      Query query = entityManager.createQuery(
              "select c from Sectionstitles c LEFT JOIN FETCH c.books a where c.id = :id ", Sectionstitles.class);
      query.setParameter("id", id);
      sectionstitles = (Sectionstitles) query.getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sectionstitles;
  }
}