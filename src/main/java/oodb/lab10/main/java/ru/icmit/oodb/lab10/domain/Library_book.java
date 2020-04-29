package ru.icmit.oodb.lab10.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Library_book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
