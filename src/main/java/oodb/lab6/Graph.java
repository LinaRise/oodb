package lab6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Graph {

  private void cleanFile(File file) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write("");
      writer.close();
    } catch (Exception e) {
      System.err.println("Error in file cleaning: " + e.getMessage());
    }
  }


  void writeToFile(File file, List<Node> nodeList, List<Edge> edgeList) {
    cleanFile(file);
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
      writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
              "<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\"  \n" +
              "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
              "    xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns\n" +
              "     http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n" +
              "  <graph id=\"G\" edgedefault=\"directed\">\n");

      for (int i = 0; i < nodeList.size(); i++) {
        Attribute[] attributeList = nodeList.get(i).attributeList;
        if (nodeList.get(i).className.toString().equals("class oodb.lab6.classes.Section"))
          continue;
        writer.write("<node id=\"" + nodeList.get(i).className + "\">\n");
        for (int j = 0; j < attributeList.length; j++) {
//          if(attributeList[j].type.contains(">"))
//            attributeList[j].type = attributeList[j].type.substring(attributeList[j].type.indexOf("<") + 1, attributeList[j].type.indexOf(">"));
//          writer.write("\t<key id=\""+attributeList[j].attributeName+"\" for=\""+nodeList.get(i).className
//                  +"\" attr.name=\""+attributeList[j].attributeName+"\" attr.type=\""+attributeList[j].type+"\"></key>\n");
//        }
//        writer.write("</node>\n");
          if (attributeList[j].type.contains(">"))
            attributeList[j].type = attributeList[j].type.substring(attributeList[j].type.indexOf("<") + 1, attributeList[j].type.indexOf(">"));
          writer.write("\t<NodeLabel>" + attributeList[j].attributeName + "</NodeLabel>\n");
        }
        writer.write("</node>\n");
      }

      for (int i = 0; i < edgeList.size(); i++) {
        writer.write("<edge id=\"" + i + "\" source=\"" + edgeList.get(i).source.className + "\" target=\"" + edgeList.get(i).target.className + "\"/>\n");

      }
      writer.write("</graph>\n</graphml>");
      writer.close();
      System.out.println("Запись окончена");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
