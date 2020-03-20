package lab9.classes;


import javax.persistence.*;
import java.util.Collection;
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
  Collection<Book> book = new TreeSet<>();

  public Library() {
  }


//  public Library(Long id, String name, TreeSet<Book> books) {
//    this.id = id;
//    this.name = name;
//    this.books = books;
//  }
//
//  public Library(String name, TreeSet<Book> books) {
//    this.name = name;
//    this.books = books;
//  }
//
//
//  Library(String name) {
//    this.name = name;
//  }
//
//  void addBook(Book book) {
//    books.add(book);
//  }

//  void removeBook(Book book) {
////    books.remove(book);
//  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public TreeSet<Book> getBooks() {
//    return (TreeSet<Book>) books;
//  }
//
//  public void setBooks(TreeSet<Book> books) {
//    this.books = books;
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  @Override
//  public String toString() {
//    return "Библиотека {" +
//            "навзание = '" + name + '\'' +
//            ", список книг = " + books +
//            '}';
//  }
}
