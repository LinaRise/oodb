package oodb.lab7.classes;


import oodb.lab7.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

@Entity
public class Library {
  @Id
  Long id;
  @Column
  String name;


  @ManyToMany
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
