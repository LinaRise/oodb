package oodb.lab5.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.TreeSet;

@XmlRootElement(name = "library")
public class Library {
  private String name;
  private TreeSet<Book> books = new TreeSet<>();

  public Library() {
  }

  public Library(String name, TreeSet<Book> books) {
    this.name = name;
    this.books = books;
  }

  Library(String name) {
    this.name = name;
  }

  void addBook(Book book) {
    books.add(book);
  }

  void removeBook(Book book) {
    books.remove(book);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElementWrapper(name = "books")
  @XmlElement(name = "book")
  public TreeSet<Book> getBooks() {
    return books;
  }

  public void setBooks(TreeSet<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Библиотека {" +
            "навзание = '" + name + '\'' +
            ", список книг = " + books +
            '}';
  }
}
