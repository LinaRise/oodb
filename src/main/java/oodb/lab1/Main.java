package oodb.lab1;

import java.util.HashSet;


public class Main {
  public static void main(String[] args) {


    Author author1 = new Author("Лев", "Николаевич", "Толстой", "Писатель, годы жизни 1828-1910");
    Author author2 = new Author("Александр", "Сергеевич", "Пушкин", "Писатель, годы жизни 1799-1837");

    Book book1 = new Book(Section.NOVEl, "Война и мир", author1, "23.09.2018", 1000);
    Book book2 = new Book(Section.CLASSIC, "Евгений Онегин", author2, "19.09.2013", 349.80);

    System.out.println(book1.getAuthor());


    HashSet<Book> books = new HashSet<>();
    books.add(book1);
    books.add(book2);


    Library library = new Library("Казанская гос библиотека", books);
    System.out.println(library);


  }
}
