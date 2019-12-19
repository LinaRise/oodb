package oodb.lab3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;


 class Main {
  final static File xmlFile = new File("library.xml");
  final static File xmlFile2 = new File("library2.xml");
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


    Library library = new Library("Казанская гос библиотека", books);


    XMLService.saveLibraryData(library);
    System.out.println("Изанчальные данные");
    Library libraryFromXML = XMLService.loadLibraryFromXML(xmlFile);
    System.out.println(libraryFromXML);

    DocumentBuilder db = null;
    try {
      db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document doc = db.parse(xmlFile);
      doc.normalize();

      // Пoлyчaeм кopнeвoй элeмeнт
      Node libraryNode = doc.getFirstChild();

      Node company = doc.getFirstChild();
      Node book = doc.getElementsByTagName("books").item(0);
      Node bookw = doc.getElementsByTagName("book").item(0);
      Node author = doc.getElementsByTagName("author").item(0);
      NodeList nodeList = bookw.getChildNodes();
      for (int i = 0; i < nodeList.getLength(); i++) {
        Node nextNode = nodeList.item(i);
        if (nextNode.getNodeName().equals("price")) {
          nextNode.setTextContent("450");
        }
      }
      NodeList authorList = author.getChildNodes();
      for (int i = 0; i < authorList.getLength(); i++) {
        Node nextNode = authorList.item(i);
        if (nextNode.getNodeName().equals("name")) {
          nextNode.setTextContent("Александр");
        }
      }



      //Сортировка по цене книги больше 500
      DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
      builderFactory.setNamespaceAware(true);
      DocumentBuilder builder = null;
      Document document = null;
      try {
        builder = builderFactory.newDocumentBuilder();
        document = builder.parse(xmlFile);
      } catch (ParserConfigurationException e) {
        e.printStackTrace();
      }

      XPathFactory xPathFactory = XPathFactory.newInstance();
      XPath xPath = xPathFactory.newXPath();
      List<String> priceMore500 = XMLService.getPriceMore500(document, xPath);
      Collections.sort(priceMore500);
      System.out.println("Цена книг больше 500: "+ priceMore500.toString());

      //Поиск по критерию
      String bookTitle = "Книжный вор";
      List<String> bookT = XMLService.getInfoByTitle(document, xPath, bookTitle);
      System.out.println("Поиск книги по названию " + bookTitle +": "+ bookT.toString());

//       Зaпиcывaeм измeнeния в XML фaйл
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(xmlFile2);
      transformer.transform(source, result);

      System.out.println("Изменения сохранены в файл library2.xml");
      libraryFromXML = XMLService.loadLibraryFromXML(xmlFile2);
      System.out.println(libraryFromXML);
    } catch (ParserConfigurationException | SAXException | IOException | TransformerException | XPathExpressionException e) {
      e.printStackTrace();
    }


//    Library libraryFromXML = XMLService.loadLibraryFromXML(xmlFile2);
//    System.out.println(libraryFromXML);
//
//    Book bookFound = XMLService.findBookByTitle(library, "Евгений Онегин");
////    System.out.println(book);
//    if (bookFound != null) {
//      //изменнение параметров найденной книги
//      bookFound.setPrice(600);
//      bookFound.setDateOfPublishing("23.09.2016");
//      System.out.println("Данные успешно обновлены");
//    } else System.out.println("Книга с данными названием не найдена");
//
//    XMLService.saveLibraryData(library);
//    libraryFromXML = XMLService.loadLibraryFromXML(xmlFile2);
//    System.out.println(libraryFromXML);
//
//
//    libraryFromXML = XMLService.loadLibraryFromXML(xmlFile);
//    TreeSet<Book> setBooks = libraryFromXML.getBooks();
//
//
//    for (Book bookEl : setBooks) {
//      int count = 0;
//      if (bookEl.getPrice() > 500) {
//        System.out.println("У книги \"" + bookEl.getTitle() + "\" стоимость больше, чем 500 и сотоавляет " + bookEl.getPrice());
//        count++;
//      }
//      if (count == 0) System.out.println("Нет книг c ценой больше 500");
//
//    }
//
//    List<Book> bookList = new ArrayList<>(setBooks);
//
//
//    Collections.sort(bookList);
////
//    setBooks = new TreeSet<Book>(bookList);
//
//
//    library.setBooks(setBooks);
//    XMLService.saveLibraryData(library);
//    libraryFromXML = XMLService.loadLibraryFromXML(xmlFile2);
//    System.out.println(libraryFromXML);

  }
}