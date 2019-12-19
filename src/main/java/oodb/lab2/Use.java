package oodb.lab2;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Use {


  //запись в файл
  static void writeToFIle(String jsonLine) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("list.json"));
      writer.write(jsonLine);
      System.out.println("Запись в файл прошла успешно");
      writer.close();
    } catch (IOException e) {
      System.out.println("Не записано");
      e.printStackTrace();
    }
  }


  //поиск книги по названию
  static Book findBookByTitle(HashSet<Book> books, String searchTitle) {
    Book result = null;
    for (Book book : books) {
      if (book.getTitle().equals(searchTitle))
        result = book;
    }
    return result;
  }


  //поиск библиотеки по названию
  static Library findLibraryByTitle(List<Library> libraries, String searchTitle) {
    Library result = null;
    for (Library library : libraries) {
      if (library.getTitleOfLibrary().equals(searchTitle))
        result = library;
    }
    return result;
  }

  //считывание
  static List<Library> loadLibraryList() {
    String libraryStr = "";
    File file = new File("list.json");

    if (file.exists()) {
      try {
        libraryStr = new String(Files.readAllBytes(file.toPath()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Файл list.json не найден!");
    }

    Gson gson = new Gson();
    Library[] libraryList = gson.fromJson(libraryStr, Library[].class);
    return Arrays.asList(libraryList);
  }


  //сохранение в формате json инфы
  static void saveLibrariesList(List<Library> libraries) {

    if (libraries != null && libraries.size() > 0) {
      Gson gson = new Gson();
      String personsAsJson = gson.toJson(libraries);

      try (OutputStream os = new FileOutputStream(new File("list.json"))) {
        os.write(personsAsJson.getBytes(StandardCharsets.UTF_8));
        os.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }
}
