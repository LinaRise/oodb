package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Book")
public class Book implements Comparable<Book> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false)
  Author author;

  @ManyToOne
  @JoinColumn(name = "sectionstitles_id", nullable = true)
  Sectionstitles sectionstitles;

  @Column(nullable = false)
  String title;

  @Column(nullable = false, length = 20)
  String UDC;

  @Column(nullable = false, length = 20)
  String LBC;

  @Basic
  @Temporal(TemporalType.DATE)
  Date dateofpublishing;

  @Column(nullable = false)
  Double price;



  public Book() {
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Sectionstitles getSectionstitles() {
    return sectionstitles;
  }

  public void setSectionstitles(Sectionstitles sectionstitles) {
    this.sectionstitles = sectionstitles;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUDC() {
    return UDC;
  }

  public void setUDC(String UDC) {
    this.UDC = UDC;
  }

  public String getLBC() {
    return LBC;
  }

  public void setLBC(String LBC) {
    this.LBC = LBC;
  }

  public Date getDateofpublishing() {
    return dateofpublishing;
  }

  public void setDateofpublishing(Date dateofpublishing) {
    this.dateofpublishing = dateofpublishing;
  }



  public String getAuthorName() {
    return author.getLastname() + " " + author.getName().charAt(0) + "." + author.getPatronymic().charAt(0) + ".";
  }

  public Long getAuthorId() {
    return author.getId();
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", author=" + author +
            ", sectionstitles=" + sectionstitles +
            ", title='" + title + '\'' +
            ", UDC='" + UDC + '\'' +
            ", LBC='" + LBC + '\'' +
            ", dateofpublishing=" + dateofpublishing +
            ", price=" + price +
            '}';
  }

  // переопредлили equals и hashCode, чтобы нельзя было добавить книги со всеми одинковыми параметрами
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Double.compare(book.price, price) == 0 &&
            sectionstitles.equals(book.sectionstitles) &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author) &&
            Objects.equals(dateofpublishing, book.dateofpublishing) &&
            Objects.equals(UDC, book.UDC) &&
            Objects.equals(LBC, book.LBC);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sectionstitles, title, author, dateofpublishing, price);
  }

  //метод для сравнения в сортировке
  @Override
  public int compareTo(Book o) {
    return (int) (this.getPrice() - o.getPrice());
  }
}
