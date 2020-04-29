package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Author;
import ru.icmit.oodb.lab10.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class BookRepository {
  @PersistenceContext(name = "entityManagerFactory")
  protected EntityManager entityManager;

  public List<Book> findAll() {

    Query query = entityManager.createQuery("select a from Book a",Book.class);


    List<Book> books = query.getResultList();

    return books;

  }

  public Book findByTitle(String title) {
    Query query = entityManager.createQuery(
            "select a from Book a where a.title like :title ", Book.class);

    query.setParameter("title", title);
    List<Book> books = query.getResultList();

    Book book = (books!=null && books.size()>0)?books.get(0):null;


    return book;
  }



}
