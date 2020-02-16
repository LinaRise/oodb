package oodb.lab7.classes;


import oodb.lab7.annotation.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Book implements Comparable<Book> {
  @Id
  Long id;

  @Column
  @ManyToOne(rightSide = SectionsTitles.class)
  Long section_id;

  @Column
  String title;


  @Column
  @ManyToOne(rightSide = Author.class)
  Long author_id;


  @Column
   String dateOfPublishing;
  @Column
  double price;

  @ManyToMany
  Set<Library> Libraries;

  //пустой конструктор тк ругается при чтении из файла
  //Class.forName( имя  класса).newInstance().
  public Book() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getSection_id() {
    return section_id;
  }

  public void setSection_id(Long section_id) {
    this.section_id = section_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }




  public String getDateOfPublishing() {
    return dateOfPublishing;
  }

  public void setDateOfPublishing(String dateOfPublishing) {
    this.dateOfPublishing = dateOfPublishing;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Книга{" +
            "секция = " + section_id +
            ", название = '" + title + '\'' +
            ", автор = " + author_id +
            ", дата публикации = '" + dateOfPublishing + '\'' +
            ", цена = " + price +
            '}';
  }

  // переопредлили equals и hashCode, чтобы нельзя было добавить книги со всеми одинковыми параметрами
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Double.compare(book.price, price) == 0 &&
            section_id.equals(book.section_id) &&
            Objects.equals(title, book.title) &&
            Objects.equals(author_id, book.author_id) &&
            Objects.equals(dateOfPublishing, book.dateOfPublishing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(section_id, title, author_id, dateOfPublishing, price);
  }

  //метод для сравнения в сортировке
  @Override
  public int compareTo(Book o) {
    return (int) (this.getPrice() - o.getPrice());
  }
}
