package oodb.lab2;

import java.util.Objects;

class Author extends Person {
  private String info;

  Author(String name, String patronymic, String lastName, String info) {
    super(name, patronymic, lastName);
    this.info = info;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "Автор {" +
            "ФИО ='" + lastName + " " + name + " " + patronymic +
            ", информация ='" + info + '\'' + '}';

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
