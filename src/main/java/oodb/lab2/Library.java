package oodb.lab2;

import java.util.HashSet;

public class Library {
  private String titleOfLibrary;
  private HashSet<Book> books = new HashSet<>();


  Library(String title_of_library, HashSet<Book> books) {
    this.titleOfLibrary = title_of_library;
    this.books = books;
  }

  Library(String name) {
    this.titleOfLibrary = name;
  }

  void addBook(Book book) {
    books.add(book);
  }

  void removeBook(Book book) {
    books.remove(book);
  }

  public String getTitleOfLibrary() {
    return titleOfLibrary;
  }

  public void setTitleOfLibrary(String titleOfLibrary) {
    this.titleOfLibrary = titleOfLibrary;
  }

  HashSet<Book> getBooks() {
    return books;
  }

  public void setBooks(HashSet<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Библиотека {" +
            "навзание = '" + titleOfLibrary + '\'' +
            ", список книг = " + books +
            '}';
  }
}
