package oodb.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

  private static String PATH_FOR_SCAN = "oodb.lab7.classes";

  public static void main(String[] args) {
    ScanDB scanDB = new ScanDB();
    ScanPackages scanPackages = new ScanPackages();


//    -------------------------------------------------------------------
    //проерка таблиц из БД и сущностей
    List<String> tablesFromDB = scanDB.getTables();
    List<String> entities = scanPackages.getEntities();
    List<String> allTables = scanPackages.getAllTables();

    java.util.Collections.sort(tablesFromDB);
    java.util.Collections.sort(entities);

    List<String> tablesFromDBCopy = null;
    List<String> allTablesCopy = null;
    boolean isEqual = tablesFromDB.equals(entities);
    if (isEqual) {
      System.out.println("Таблицы и сущности совпадают");

    } else {
      System.out.println("Таблицы и сущности не совпадают\n");
      if (tablesFromDB.size() > entities.size()) {
        tablesFromDBCopy = new ArrayList<>(tablesFromDB);
        tablesFromDBCopy.removeAll(entities);
        System.out.println("Дополнитльные таблицы из БД: " + tablesFromDBCopy+"\n");

        allTablesCopy = new ArrayList<>(allTables);
        allTablesCopy.removeAll(entities);
        System.out.println("Дополнитльные таблицы из пакета: " + allTablesCopy+"\n");

      }
    }

//    -------------------------------------------------------------------
    System.out.println(" \n-------------------------------------------------------------------");

    //проверка полей таблиц
    HashMap<String, List<String>> tablesWithFields = new HashMap<>();
    List<String> fieldsFromDb;
    List<String> fields;
    List<String> fieldsFromDbLast;


    for (int i = 0; i < entities.size(); i++) {
      System.out.println();
      System.out.println("Поля таблицы - " + entities.get(i));
      fields = scanPackages.getFields(entities.get(i).toLowerCase());
      System.out.println("Поля таблицы из БД - " + entities.get(i).toLowerCase());
      fieldsFromDb = scanDB.getFields(entities.get(i).toLowerCase());
      fieldsFromDb.forEach(System.out::println);
    }

    System.out.println(" \n-------------------------------------------------------------------");
    System.out.println("\n\nТаблицы из БД без соответствия");
    for(int i=0;i<tablesFromDBCopy.size();i++){
      System.out.println();
      System.out.println("Поля таблицы из БД - " + tablesFromDBCopy.get(i).toLowerCase());
      fieldsFromDbLast = scanDB.getFields(tablesFromDBCopy.get(i).toLowerCase());
      fieldsFromDbLast.forEach(System.out::println);
    }



  }
}
