package oodb.lab1;

 import java.util.HashSet;

public class Library {
  private String name;
  private HashSet<Book> books = new HashSet<>();


  Library(String name, HashSet<Book> books) {
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

  public HashSet<Book> getBooks() {
    return books;
  }

  public void setBooks(HashSet<Book> books) {
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
