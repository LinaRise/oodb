package lab6.classes;


import lab6.annotation.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Book implements Comparable<Book> {
  @Column
  int id;
  @Column
  @Enumerated
  private Section section;
  @Column
  private String title;
  @Column
  @ManyToOne
  private Author author1;
  @Column
  private String dateOfPublishing;
  @Column
  private double price;

  @OneToMany
  Set<BooksInLibraries> booksInLibraries;

  //пустой конструктор тк ругается при чтении из файла
  //Class.forName( имя  класса).newInstance().
  public Book() {
  }

  public Book(int id, Section section, String title, Author author, String dateOfPublishing, double price) {
    this.id = id;
    this.section = section;
    this.title = title;
    this.author1 = author;
    this.dateOfPublishing = dateOfPublishing;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Book(Section section, String title, Author author, String dateOfPublishing, double price) {
    this.section = section;
    this.title = title;
    this.author1 = author;
    this.dateOfPublishing = dateOfPublishing;
    this.price = price;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  Author getAuthor1() {
    return author1;
  }

  public void setAuthor1(Author author1) {
    this.author1 = author1;
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
            "секция = " + section +
            ", название = '" + title + '\'' +
            ", автор = " + author1 +
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
            section == book.section &&
            Objects.equals(title, book.title) &&
            Objects.equals(author1, book.author1) &&
            Objects.equals(dateOfPublishing, book.dateOfPublishing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(section, title, author1, dateOfPublishing, price);
  }

  //метод для сравнения в сортировке
  @Override
  public int compareTo(Book o) {
    return (int) (this.getPrice() - o.getPrice());
  }
}
