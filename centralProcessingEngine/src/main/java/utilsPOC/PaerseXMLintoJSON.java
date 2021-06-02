package utilsPOC;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import org.json.JSONObject;
import org.json.XML;

public class PaerseXMLintoJSON {

  public static void main(String args[]) {

    String xml;
    try {
      xml = readFile("/users/i355696/Documents/NSE-DATA/xml/samplexml/1.xml");
      parse(xml);
    } catch (IOException e) {
      System.out.print("----error------");
    }


  }

  private static void parse(String xml) {

    JSONObject xmlJSONObj = XML.toJSONObject(xml);
    System.out.println("----done------");
    System.out.print(xmlJSONObj.toString(4));
    Set<String> keys = ((JSONObject) xmlJSONObj.get("xbrli:xbrl")).keySet();
    System.out.print(keys);


  }



  public static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, StandardCharsets.US_ASCII);
  }


}
