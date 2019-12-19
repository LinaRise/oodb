package oodb.lab4;

import java.util.HashSet;
import java.util.TreeSet;
import oodb.lab4.*;
import oodb.lab4.classes.Author;
import oodb.lab4.classes.Book;
import oodb.lab4.classes.Library;
import oodb.lab4.classes.Section;

public class Test {
  public static void main(String[] args) {
    Author author1 = new Author("Лев", "Николаевич", "Толстой", "Писатель, годы жизни 1828-1910");
    Author author2 = new Author("Алексей", "Сергеевич", "Пушкин", "Писатель, годы жизни 1799-1837");
    Author author3 = new Author("Марк", "", "Зусак", "Писатель, годы жизни 1975-");
    Author author4 = new Author("Рэй", "", "Брэдбери", "Писатель, годы жизни 1920-2010");

    Book book1 = new Book(Section.NOVEl, "Война и мир", author1, "23.09.2018", 1000);
    Book book2 = new Book(Section.CLASSIC, "Евгений Онегин", author2, "19.09.2013", 349.80);
    Book book3 = new Book(Section.NOVEl, "Книжный вор", author3, "23.09.2016", 1243);
    Book book4 = new Book(Section.CLASSIC, "451 градус по Фаренгейту", author4, "19.09.2008", 398);
    Book book5 = new Book(Section.CLASSIC, "Евгений Онегин", author2, "09.09.2015", 200);


    TreeSet<Book> books = new TreeSet<>();

    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    books.add(book5);

    TreeSet<Book> books2 = new TreeSet<>();
    books2.add(book3);
    books2.add(book4);
    books2.add(book5);



    Library library = new Library("Казанская гос библиотека", books);
    Library library2 = new Library("Центральная Казанская библиотека", books2);
    Library library3 = new Library("Центральная Приволжская библиотека", books2);
    Library library4 = new Library("Детская библиотека № 1409", books2);
    Library library5 = new Library("Совесткая библиотека им. Толстого", books);
    Database database = new Database();
      database.saveToDB(library);
      database.saveToDB(library2);
      database.saveToDB(library3);
      database.saveToDB(library4);
      database.saveToDB(library5);
    database.loadFromDB();
    database.searchInDB();
    database.sort();

  }
}
