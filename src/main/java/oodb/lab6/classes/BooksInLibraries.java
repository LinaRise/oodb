package lab6.classes;


import lab6.annotation.Column;
import lab6.annotation.ManyToOne;

public class BooksInLibraries {
  @Column
  int id;

  @Column
  @ManyToOne
  Book book;

  @Column
  @ManyToOne
  Library library;


  public BooksInLibraries(int id, Book book, Library library) {
    this.id = id;
    this.book = book;
    this.library = library;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Library getLibrary() {
    return library;
  }

  public void setLibrary(Library library) {
    this.library = library;
  }
}
