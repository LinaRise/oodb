package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sectionstitles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;

  @Column(length = 60,nullable = false)
  String title;


  @OneToMany(mappedBy = "sectionstitles")
  List<Book> books = new ArrayList<>();




  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Sectionstitles{" +
            "id=" + id +
            ", title='" + title + '\'';
  }
}
