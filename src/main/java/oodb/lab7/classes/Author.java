package oodb.lab7.classes;


import oodb.lab7.annotation.Column;
import oodb.lab7.annotation.Entity;
import oodb.lab7.annotation.Id;
import oodb.lab7.annotation.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity(name = "Author")
public class Author extends Person {
  @Id
  Long id;

  @Column
   String info;



  @OneToMany
   List<Book> book;


  //пустой конструктор тк ругается при чтении из файла
  public Author() {
  }

  public Author(String name, String patronymic, String lastName, String info) {
    super(name, patronymic, lastName);
    this.info = info;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public String getInfo() {
    return info;
  }

  public String getFullName() {
    return name + " " + patronymic + " " + lastname;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "Автор {" +
            "информация ='" + info + '\'' +
            ", ФИО ='" + lastname + " " + name + " " + patronymic + '}';
  }


  //hashCode и equals, чтобы при доавлении такого же автора нельзя юыло создать книгу с сущ параметрами
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return Objects.equals(info, author.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info);
  }
}
