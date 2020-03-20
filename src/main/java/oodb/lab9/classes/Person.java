package lab9.classes;


import javax.persistence.*;

@MappedSuperclass
public abstract class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;
  @Column(length = 60,nullable = false)
  String name;
  @Column(length = 60,nullable = false)
  String patronymic;
  @Column(length = 60,nullable = false  )
  String lastname;


  public Person() {
  }

  Person(String name, String patronymic, String lastName) {
    this.name = name;
    this.patronymic = patronymic;
    this.lastname = lastName;
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

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
