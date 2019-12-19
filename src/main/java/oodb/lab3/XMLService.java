package oodb.lab3;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class XMLService {

  static void saveLibraryData(Library library) {

    try {
      JAXBContext context = JAXBContext.newInstance(Library.class);
      Marshaller marshaller = context.createMarshaller();
      // true для того, чтобы записал не в одну строчку, а красиво
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      // маршаллинг объекта в файл
      marshaller.marshal(library, new File("library.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }


  static Library loadLibraryFromXML(File file) {

    try {
      // создаем объект JAXBContext - точку входа для JAXB
      JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
      Unmarshaller un = jaxbContext.createUnmarshaller();

      return (Library) un.unmarshal(file);
    } catch (JAXBException e) {
      e.printStackTrace();
    }

    return null;
  }

  public static List<String> getInfoByTitle (Document doc, XPath xPath, String bookTitle) throws XPathExpressionException {
    List<String> list = new ArrayList<>();
    XPathExpression xPathExpression =xPath.compile("/library/books/book[title='"+ bookTitle +"']/author/lastName/text()");
    NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
    for (int o = 0; o < nodes.getLength();o++){
      list.add(nodes.item(o).getNodeValue());
    }
    return list;
  }

//цена книга больше 500
  static List<String> getPriceMore500(Document doc, XPath xPath)  {
    List<String> list = new ArrayList<>();
    XPathExpression xPathExpression = null;
    try {
      xPathExpression = xPath.compile("/library/books/book[price>500]/title/text()");
    } catch (XPathExpressionException e) {
      e.printStackTrace();
    }
    NodeList nodes = null;
    try {
      nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
    } catch (XPathExpressionException e) {
      e.printStackTrace();
    }
    for (int o = 0; o < nodes.getLength();o++){
      list.add(nodes.item(o).getNodeValue());
    }
    return list;
  }

  //поиск библиотеки по названию
  static Book findBookByTitle(Library library, String searchTitle) {
    TreeSet<Book> listBook = library.getBooks();
    Book result = null;
    for (Book book : listBook) {
      if (book.getTitle().equals(searchTitle))
        result = book;
    }
    return result;
  }
}
