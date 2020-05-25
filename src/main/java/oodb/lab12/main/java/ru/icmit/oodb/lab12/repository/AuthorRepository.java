package ru.icmit.oodb.lab12.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icmit.oodb.lab12.domain.Author;
import ru.icmit.oodb.lab12.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class AuthorRepository {

  @PersistenceContext(name = "entityManagerFactory")
  protected EntityManager entityManager;

  public List<Author> findAll() {

    Query query = entityManager.createQuery("select a from Author a", Author.class);


    List<Author> authors = query.getResultList();
    Author author = (authors != null && authors.size() > 0) ? authors.get(0) : null;

    return authors;

  }

  public Author findByName(String lastname) {
    Query query = entityManager.createQuery(
            "select a from Author a where a.lastname like :lastname ", Author.class);

    query.setParameter("lastname", lastname);
    List<Author> authors = query.getResultList();

    Author author = (authors != null && authors.size() > 0) ? authors.get(0) : null;


    return author;
  }

  public Author findById(Long id) {
    return entityManager.find(Author.class, id);
  }


  @Transactional
  public Author save(Author author) {

    if (author == null) return null;
    if (author.getId() != null) {
      author = entityManager.merge(author);
    } else {
      entityManager.persist(author);
    }
    return author;
  }


  // Запрос данных клиента вместе с его расчетными счетами (при работе с "ленивой" загрузкой коллекций)
  public Author getFetchAuthor(Long id) {
    Author author = null;
    try {
      Query query = entityManager.createQuery(
              "select c from Author c LEFT JOIN FETCH c.book a where c.id = :id ", Author.class);
      query.setParameter("id", id);
      author = (Author) query.getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return author;
  }


  // Запрос расчетных счетов клиента
  public List<Book> getAuthorBooks(Author author) {
    Query query = entityManager.createQuery(
            "select a from Author c JOIN c.book a where c = :author ", Book.class);
    query.setParameter("author", author);

    return query.getResultList();
  }


  // Найти автора по книге
  public Author findByBookId(Long id) {

    Query query = entityManager.createQuery(
            "select c from Author c JOIN c.book a where  a.id = :id ", Author.class);
    query.setParameter("id", id);
    try {
      return (Author) query.getSingleResult();
    } catch (Exception e) {
    }

    return null;
  }

  @Transactional
  public boolean removeAuthor(Long id) {
    Author author = entityManager.find(Author.class, id);
    if (author == null) return false;

    entityManager.remove(author);

    return true;


  }


  // Поиск клиента по имени (3 варианта запросов, включая "чистый" SQL)
  public List<Author> findByLastName(String lastname) {
    Query query = entityManager.createQuery(
            //"select c from ClientData c where name like :name ", ClientData.class);
            "select c from Author c where c.lastname like :lastname ", Author.class);

    //Query query = entityManager.createNativeQuery(
    //        "select * from clientdata where name like :name ", ClientData.class);

    query.setParameter("lastname", '%' + lastname + '%');

    return (List<Author>) query.getResultList();
  }


  // Удалить книгу по его ID
  @Transactional
  public boolean removeBook(Long id) {
    Book book = entityManager.find(Book.class, id);
    System.out.println("УДаление " + book);

    if (book == null) return false;

    entityManager.remove(book);

    return true;
  }

  @Transactional
  public boolean removeAuthorBook(Long id) {
    Book book = entityManager.find(Book.class, id);
    if (book == null) return false;
    System.out.println(book);
    System.out.println("!1111111");
    entityManager.remove(book);

    return true;


  }


  // Удалить все расчетные счета клиента по его ID
  @Transactional
  public boolean removeAuthorBooks(Long id) {
    System.out.println("id = " + id);
    Author author = entityManager.find(Author.class, id);

    if (author == null) return false;
    System.out.println("author = " + author.getId() + author.getName());
    List<Book> books = author.getBook();
    System.out.println("Список книг = "+books);
    if (books == null) return false;
    System.out.println("book = " + books.get(0).getId() + books.get(0).getAuthorId());
    System.out.println("book = " + books.get(1).getId() + books.get(1).getAuthorId());
    books.clear();
//    System.out.println("author = "+books.get(0).getId()+books.get(0).getAuthorId());
    author.setBook(books);
    System.out.println("Список книг = "+books);

    entityManager.merge(author);

    return true;
  }
}

