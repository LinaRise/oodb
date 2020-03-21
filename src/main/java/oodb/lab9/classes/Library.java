package lab9.classes;


import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity(name = "Library")
public class Library {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;
  @Column(nullable = false)
  String name;


  @ManyToMany
  @JoinTable(
          name = "library_book",
          joinColumns = @JoinColumn(name = "library_id"),
          inverseJoinColumns = @JoinColumn(name = "book_id")
  )
  Set<Book> book;

  public Library() {
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Library library = (Library) o;
    return Objects.equals(name, library.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


}
