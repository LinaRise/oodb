package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Author extends Person {

  @Column
  String info;


  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
  List<Book> book = new ArrayList<>();


  public String getInfo() {
    return info;
  }


  public void setInfo(String info) {
    this.info = info;
  }

  public List<Book> getBook() {
    return book;
  }

  public void setBook(List<Book> book) {
    this.book = book;
  }

  //пустой конструктор тк ругается при чтении из файла
  public Author() {
  }

  public Author(String name, String patronymic, String lastName, String info) {
    super(name, patronymic, lastName);
    this.info = info;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }



  //hashCode и equals, чтобы при доавлении такого же автора нельзя юыло создать книгу с сущ параметрами
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return Objects.equals(name, author.name) &&
            Objects.equals(patronymic, author.patronymic) &&
            Objects.equals(lastname, author.lastname) &&
            Objects.equals(info, author.info);
  }

  @Override
  public String toString() {
    return "Author{" +
            "info='" + info ;

  }

  @Override
  public int hashCode() {
    return Objects.hash(info);
  }
}


