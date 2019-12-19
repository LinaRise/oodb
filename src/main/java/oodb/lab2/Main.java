package oodb.lab2;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
  public static void main(String[] args) {


    Author author1 = new Author("Лев", "Николаевич", "Толстой", "Писатель, годы жизни 1828-1910");
    Author author2 = new Author("Александр", "Сергеевич", "Пушкин", "Писатель, годы жизни 1799-1837");

    Book book1 = new Book(Section.NOVEl, "Война и мир", author1, "23.09.2018", 1000);
    Book book2 = new Book(Section.CLASSIC, "Евгений Онегин", author2, "19.09.2013", 349.80);


    HashSet<Book> books = new HashSet<>();
    books.add(book1);
    books.add(book2);


    Library library = new Library("Казанская гос библиотека", books);


    Author author3 = new Author("Марк", "", "Зусак", "Писатель, годы жизни 1975-");
    Author author4 = new Author("Рэй", "", "Брэдбери", "Писатель, годы жизни 1920-2010");

    Book book3 = new Book(Section.NOVEl, "Книжный вор", author3, "23.09.2016", 1000);
    Book book4 = new Book(Section.CLASSIC, "451 градус по Фаренгейту", author4, "19.09.2008", 398);
    Book book5 = new Book(Section.CLASSIC, "Евгений Онегин", author2, "09.09.2015", 200);


    HashSet<Book> books2 = new HashSet<>();
    books2.add(book3);
    books2.add(book4);
    books2.add(book5);


    Library library2 = new Library("Центральная Казанская библиотека", books2);

    //объекты для работы с json при помощи gson
    Gson gson = new Gson();

    //добавлние библиотек в HashSet и их запись в json формате
    HashSet<Library> listOfLibraries = new HashSet<>();
    listOfLibraries.add(library);
    listOfLibraries.add(library2);
    String jsonString = gson.toJson(listOfLibraries);
    Use.writeToFIle(jsonString);


    //выводим в консоль json элементы
    List<Library> libraries = Use.loadLibraryList();
    libraries.forEach(System.out::println);


//поиск опред библиотеки
    Library fLibrary = Use.findLibraryByTitle(libraries, "Центральная Казанская библиотека");
    //поиск по библиотеке и книге в ней
    if (fLibrary != null) {
      //поиск определенной книги
      Book book = Use.findBookByTitle(fLibrary.getBooks(), "451 градус по Фаренгейту");
      if (book != null) {
        //изменнение параметров найденной книги
        book.setPrice(600);
        book.setDateOfPublishing("23.09.2016");
        System.out.println("Данные успешно обновлены");
      } else System.out.println("Книга с данными названием не найдена");
    } else System.out.println("Бибилиотека с данным названием не найдена");


//запись измененных данных
    Use.saveLibrariesList(libraries);


    //вывод названия библиотек где книг больше, чем 2
    libraries = Use.loadLibraryList();
    int count = 0;
    for (Library libraryEl : libraries) {
      if (libraryEl.getBooks().size() > 2) {
        System.out.println("В \"" + libraryEl.getTitleOfLibrary() + "\" книг больше, чем 2");
        count++;
      }
      if (count == 0) System.out.println("Библиотек с книгами больше 2 не найдено");

    }


    List bookList = new ArrayList<>();
    for (Library libraryEl : libraries) {
      HashSet bookSet = libraryEl.getBooks();
      bookList.addAll(bookSet);
    }

    //сортировка вскх книг в библиотеках по цене по возрастанию
    Collections.sort(bookList);
    for (Object aBookList : bookList) {
      System.out.println(aBookList);
    }


  }
}
