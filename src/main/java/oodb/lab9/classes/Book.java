package lab9.classes;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

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
  @JoinColumn(name = "sectionstitles_id", nullable = false)
  Sectionstitles sectionstitles;

  @Column(nullable = false)
  String title;

  @Column(nullable = false, length = 20)
  String UDC;

  @Column(nullable = false,length = 20)
  String LBC;


  @Temporal(TemporalType.DATE)
  Date dateofpublishing;
  @Column(nullable = false)
  Double price;

  @ManyToMany(mappedBy = "book")
  Set<Library> libraries;


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

  public String getLBC() {
    return LBC;
  }

  public void setLBC(String LBC) {
    this.LBC = LBC;
  }

  public String getUDC() {
    return UDC;
  }

  public void setUDC(String UDC) {
    this.UDC = UDC;
  }

  public Date getDateofpublishing() {
    return dateofpublishing;
  }

  public void setDateofpublishing(Date dateofpublishing) {
    this.dateofpublishing = dateofpublishing;
  }

  public Set<Library> getLibraries() {
    return libraries;
  }

  public void setLibraries(Set<Library> libraries) {
    this.libraries = libraries;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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
            ", libraries=" + libraries +
            '}';
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
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
