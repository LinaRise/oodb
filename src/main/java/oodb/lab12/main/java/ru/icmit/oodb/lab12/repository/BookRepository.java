package ru.icmit.oodb.lab12.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icmit.oodb.lab12.domain.Author;
import ru.icmit.oodb.lab12.domain.Book;
import ru.icmit.oodb.lab12.domain.BookInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class BookRepository {
  @PersistenceContext(name = "entityManagerFactory")
  protected EntityManager entityManager;

  public List<Book> findAll() {

    Query query = entityManager.createQuery("select a from Book a", Book.class);


    List<Book> books = query.getResultList();

    return books;

  }

  public Book findByTitle(String title) {
    Query query = entityManager.createQuery(
            "select a from Book a where a.title like :title ", Book.class);

    query.setParameter("title", title);
    List<Book> books = query.getResultList();

    Book book = (books != null && books.size() > 0) ? books.get(0) : null;


    return book;
  }



  public List<BookInfo> findByTitleBooks(String title) {
    Query query = entityManager.createQuery(
            "select b from BookInfo b where b.booktitle like :title ", BookInfo.class);

    query.setParameter("title", '%'+title+'%');


    return (List<BookInfo>) query.getResultList();
  }


  public List<Book> findAuthorsBook(Author author) {

    Query query = entityManager.createQuery(
            "select a from Book a where a.author = :author ", Book.class);

    query.setParameter("author", author);
    List<Book> books = query.getResultList();

    return books;

  }





  public Book findById(Long id) {
    return entityManager.find(Book.class, id);
  }

  @Transactional
  public Book save(Book book) {
    if (book != null && book.getId() != null) {
      book = entityManager.merge(book);
    } else {
      entityManager.persist(book);
    }

    return book;
  }




  @Transactional
  public boolean removeBook(Long id) {
    Book book = entityManager.find(Book.class, id);

    if (book == null) return false;
    System.out.println("found" + book.getId() + book.getTitle());
    entityManager.remove(book);

    return true;


  }




}
