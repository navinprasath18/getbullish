package utilsPOC;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class XMLurlsfromnse {

  public static void main(String args[]) {

    try {
      getEmployees();
      JSONObject json = new JSONObject(IOUtils.toString(new URL(
          "https://www.nseindia.com/api/corporates-financial-results?index=equities&symbol=RELIANCE"),
          Charset.forName("UTF-8")));
      System.out.println("---");
      System.out.println(json.toString());
    } catch (JSONException | IOException e) {
      System.out.println("---");
    }


  }
  
  private static void getEmployees()
  {
      final String uri = "https://www.nseindia.com/api/corporates-financial-results?index=equities&symbol=RELIANCE";

      RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(uri, String.class);

      System.out.println(result);
  }
}
