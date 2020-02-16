package oodb.lab7.classes;


import oodb.lab7.annotation.Column;

abstract class Person {
  @Column
  public String name;
  @Column
  public String patronymic;
  @Column
  public String lastName;


  public Person() {
  }

  Person(String name, String patronymic, String lastName) {
    this.name = name;
    this.patronymic = patronymic;
    this.lastName = lastName;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
