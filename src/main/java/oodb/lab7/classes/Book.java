package oodb.lab7.classes;


import oodb.lab7.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book implements Comparable<Book> {
  @Id
  Long id;

  @Column
  @ManyToOne
  Author author;

  @Column
  @ManyToOne
  SectionsTitles sectionsTitles;

  @Column
  String title;





  @Column
   String dateOfPublishing;
  @Column
  double price;

  @ManyToMany
  Collection<Library> libraries;

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
            "секция = " + sectionsTitles +
            ", название = '" + title + '\'' +
            ", автор = " + author +
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
            sectionsTitles.equals(book.sectionsTitles) &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author) &&
            Objects.equals(dateOfPublishing, book.dateOfPublishing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sectionsTitles, title, author, dateOfPublishing, price);
  }

  //метод для сравнения в сортировке
  @Override
  public int compareTo(Book o) {
    return (int) (this.getPrice() - o.getPrice());
  }
}
