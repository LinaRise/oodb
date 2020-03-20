package lab9.classes;


import javax.persistence.*;
import java.util.List;

@Entity
public class Sectionstitles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;

  @Column(length = 60,nullable = false)
  String sectionstitles;


  @OneToMany(mappedBy = "sectionstitles", cascade = CascadeType.REMOVE)
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
