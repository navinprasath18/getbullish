package utilsPOC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parsermainclass {

  private static final String FILENAME = "/users/i355696/Documents/NSE-DATA/xml/xblr.xml";

  public static void main(String[] args) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder;
    Document doc = null;
    try {
      builder = factory.newDocumentBuilder();
      doc = builder.parse(FILENAME);

      // Create XPathFactory object
      XPathFactory xpathFactory = XPathFactory.newInstance();

      // Create XPath object
      XPath xpath = xpathFactory.newXPath();
      XPathExpression expr = xpath.compile("/xbrli:xbrl/in-bse-fin:Symbol/text()");
      NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
      List<String> list = new ArrayList<>();
      for (int i = 0; i < nodes.getLength(); i++)
        list.add(nodes.item(i).getNodeValue());
      System.out.print(list);

    } catch (ParserConfigurationException | SAXException | IOException
        | XPathExpressionException e) {
      e.printStackTrace();
    }


  }
}

