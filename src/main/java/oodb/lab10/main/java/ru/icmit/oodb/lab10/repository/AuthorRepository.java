package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Author;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class AuthorRepository {

    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    public List<Author> findAll() {

        Query query = entityManager.createQuery("select a from Author a",Author.class);


        List<Author> authors = query.getResultList();

        return authors;

    }

    public Author findByName(String lastname) {
        Query query = entityManager.createQuery(
                "select a from Author a where a.lastname like :lastname ", Author.class);

        query.setParameter("lastname", lastname);
      List<Author> authors = query.getResultList();

      Author author = (authors!=null && authors.size()>0)?authors.get(0):null;


        return author;
    }

}
