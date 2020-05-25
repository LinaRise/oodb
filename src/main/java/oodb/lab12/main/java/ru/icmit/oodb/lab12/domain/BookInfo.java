package ru.icmit.oodb.lab12.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

//create view bookinfo as select b.id, b.title as booktitle, s2.title from book b join sectionstitles s2 on b.sectionstitles_id = s2.id
@Entity
public class BookInfo {

  @Id
  private Long id;

  private  String booktitle;
  private String lastname;
  private String name;
  private String patronymic;
  private String sectiontitle;

  public BookInfo() {
  }

  public BookInfo(Long id, String booktitle, String lastname, String name, String patronymic, String sectiontitle) {
    this.id = id;
    this.booktitle = booktitle;
    this.lastname = lastname;
    this.name = name;
    this.patronymic = patronymic;
    this.sectiontitle = sectiontitle;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBooktitle() {
    return booktitle;
  }

  public void setBooktitle(String booktitle) {
    this.booktitle = booktitle;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
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

  public String getSectiontitle() {
    return sectiontitle;
  }

  public void setSectiontitle(String sectiontitle) {
    this.sectiontitle = sectiontitle;
  }

  @Override
  public String toString() {
    return "BookInfo{" +
            "id=" + id +
            ", booktitle='" + booktitle + '\'' +
            ", lastname='" + lastname + '\'' +
            ", name='" + name + '\'' +
            ", patronymic='" + patronymic + '\'' +
            ", sectiontitle='" + sectiontitle + '\'' +
            '}';
  }
}
