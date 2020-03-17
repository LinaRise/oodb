package oodb.lab8.classes;

import oodb.lab8.annotation.Column;
import oodb.lab8.annotation.Entity;
import oodb.lab8.annotation.Id;
import oodb.lab8.annotation.OneToMany;

import java.util.List;

@Entity
public class Sectionstitles {
  @Id
  Long id;

  @Column
  String sectionstitles;


  @OneToMany
   List<Book> books;

  @Override
  public String toString() {
    return "Sectionstitles{" +
            "id=" + id +
            ", sectionstitles='" + sectionstitles + '\'' +
            ", books=" + books +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSectionstitles() {
    return sectionstitles;
  }

  public void setSectionstitles(String sectionstitles) {
    this.sectionstitles = sectionstitles;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
