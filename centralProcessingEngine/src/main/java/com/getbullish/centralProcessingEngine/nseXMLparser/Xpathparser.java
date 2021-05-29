package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xpathparser {

  public static void main(String[] args) {
    try {
      parsr("/users/i355696/Documents/NSE-DATA/xml/xblr.xml");
    } catch (ParserConfigurationException | SAXException | IOException e) {
      System.out.println("============================");
    }
  }


  public static void parsr(String dir)

      // "/users/i355696/Documents/NSE-DATA/xml/xblr.xml"
      throws ParserConfigurationException, SAXException, IOException {
    // Get Document Builder
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    // Build Document
    Document document = builder.parse(new File(dir));

    // Normalize the XML Structure; It's just too important !!
    document.getDocumentElement().normalize();

    // Here comes the root node
    Element root = document.getDocumentElement();
    System.out.println(root.getNodeName());
    System.out.println(document.getDocumentElement().getChildNodes());
    System.out.println(document.getDocumentElement().getChildNodes().getLength());
    System.out.println(document.getDocumentElement().getChildNodes());

    // Get all employees
    NodeList nList = document.getDocumentElement().getChildNodes();
    System.out.println("============================");

    NSExml entity = visitChildNodes(nList);
    System.out.println(entity.getNodesAndValues());
    for (String str : entity.getNodes()) {
      System.out.println(str + ":" + entity.getNodesAndValues().get(str));
    }
    // for(Map.Entry<String, String> entry : entity.getNodesAndValues().entrySet()) {
    // System.out.println(entry);
    // }
  }

  // This function is called recursively
  private static NSExml visitChildNodes(NodeList nList) {
    NSExml entity = new NSExml();
    for (int temp = 0; temp < nList.getLength(); temp++) {
      Node node = nList.item(temp);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        System.out
            .print("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
        entity.addnode(node.getNodeName());
        entity.addnodevalue(node.getNodeName(), node.getTextContent());
        // Check all attributes
        if (node.hasAttributes()) {
          // get attributes names and values
          NamedNodeMap nodeMap = node.getAttributes();
          for (int i = 0; i < nodeMap.getLength(); i++) {
            Node tempNode = nodeMap.item(i);
            System.out.print(
                " Attr name : " + tempNode.getNodeName() + "; Value = " + tempNode.getNodeValue());
          }
          if (node.hasChildNodes()) {
            // We got more childs; Let's visit them as well
            visitChildNodes(node.getChildNodes());
          }
        }
      }
      System.out.println("---");
    }

    return entity;
  }


}
