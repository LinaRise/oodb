package oodb.lab5.classes;

import java.util.Comparator;

public class NameComparator implements Comparator<Book> {
  @Override
  public int compare(Book o1, Book o2) {
    return (int) (o1.getPrice()-o2.getPrice());
  }
}
