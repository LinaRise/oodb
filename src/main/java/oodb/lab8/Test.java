package oodb.lab8;

import oodb.lab8.classes.Author;
import oodb.lab8.classes.Book;
import oodb.lab8.classes.Person;
import oodb.lab8.classes.Sectionstitles;


public class Test {


  public static void main(String[] args) {
    EntityManagerImpl entityManager = new EntityManagerImpl();

    Person author = new Author();
    author.setName("Николай");
    author.setPatronymic("Васильевич");
    author.setLastname("Гоголь");
    ((Author) author).setInfo("писатель");

    Person author2 = new Author();
    author.setName("Никак");
    author.setPatronymic("Уже");
    author.setLastname("Просто");
    ((Author) author).setInfo("поэт");

    entityManager.persist(author);
    entityManager.persist(author2);


//    System.out.println(((Author) author).getId() + "автор");


    // Method[] method = author.getClass().getMethods();
    //   System.out.println(Arrays.toString(method));
//    Field fields[] = null;

    Sectionstitles sectionsTitles = new Sectionstitles();
    sectionsTitles.setSectionstitles("Повесть");
    entityManager.persist(sectionsTitles);

//    System.out.println("id!!!" + sectionsTitles.getId());
//
    Book book = new Book();
    book.setTitle("Работай уже!!!");
    book.setAuthor((Author) author);
    book.setSectionstitles(sectionsTitles);
    book.setDateofpublishing("24.05.2008");
    book.setPrice(23.0);
    entityManager.persist(book);

    ((Author) author).setInfo("Писатель и поэт");

    entityManager.merge(author);
//    System.out.println(((Author) author).getId() + "автор");

    book.setDateofpublishing("30.05.2015");
    book.setAuthor((Author) author2);

    entityManager.merge(book);


    entityManager.remove(book);
    entityManager.remove(sectionsTitles);
//    System.out.println(Double.class);

    Object object = entityManager.find(Book.class, 1);
    System.out.println(object.toString()+"!!!!!!!");

    entityManager.close();


//    System.out.println(Arrays.toString(Author.class.getDeclaredMethods()));


  }
}

//    if (author.getClass().getCanonicalName().equals("oodb.lab8.classes.Author")) {
//      Field[] personFields = Author.class.getSuperclass().getDeclaredFields();
//      Field[] authorFields = Author.class.getDeclaredFields();
//      fields = new Field[authorFields.length + personFields.length];
//      Arrays.setAll(fields, i ->
//              (i < personFields.length ? personFields[i] : authorFields[i - personFields.length]));
////        System.out.println("Автор = "+Arrays.toString(fields));

//    for (Field field : fields) {
//      System.out.println("Поле "+field);
//
//      List<Annotation> list = new ArrayList<>(Arrays.asList(field.getAnnotations()));
//      for (int i = 0; i < list.size(); i++) {
//        if (list.get(i).toString().contains("Column") && list.size()>=2) {
//          list.remove(list.get(i));
//        }
//      }
//      Annotation[] annotation = new Annotation[list.size()];
//      list.toArray(annotation);
//      System.out.println(Arrays.toString(annotation));
//
//    }
//
//  }

//    titles.setSectionstitles("Драма");
//
//    entityManager.refresh(titles);



