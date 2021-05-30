package utilsPOC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class TradownloadingCML {



  public static void main(String[] args) throws Exception {
    URL url = new URL(
        "http://archives.nseindia.com/corporate/xbrl/INDAS_69589_445286_30042021080201_WEB.xml");
    URLConnection conn = url.openConnection();
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
      var pageText = reader.lines().collect(Collectors.joining("\n"));
      System.out.print(pageText);
    }
  }
}
