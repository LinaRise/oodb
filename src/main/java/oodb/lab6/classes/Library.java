package lab6.classes;


import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.OneToMany;

import java.util.TreeSet;

@Entity
public class Library {
  @Column
  int id;
  @Column
  private String name;
  @Column
  @OneToMany
  private TreeSet<Book> books = new TreeSet<>();

  public Library() {
  }

  public Library(int id, String name, TreeSet<Book> books) {
    this.id = id;
    this.name = name;
    this.books = books;
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

  public TreeSet<Book> getBooks() {
    return books;
  }

  public void setBooks(TreeSet<Book> books) {
    this.books = books;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Библиотека {" +
            "навзание = '" + name + '\'' +
            ", список книг = " + books +
            '}';
  }
}
