package oodb.lab7.classes;

import oodb.lab7.annotation.Column;
import oodb.lab7.annotation.Entity;
import oodb.lab7.annotation.Id;
import oodb.lab7.annotation.OneToMany;

import java.util.List;

@Entity
public class SectionsTitles {
  @Id
  Long id;

  @Column
  String sectionstitles;


  @OneToMany
   List<Book> books;



  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
