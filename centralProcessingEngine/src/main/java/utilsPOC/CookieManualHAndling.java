package utilsPOC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CookieManualHAndling {

  public static void main(String[] args) {
    getCookiees();
  }



  public static void getCookiees() {
    BasicCookieStore cookieStore = new BasicCookieStore();
    HttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
    try {


      HttpGet request = new HttpGet("https://www.nseindia.com/");

      request.addHeader(HttpHeaders.USER_AGENT,
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
      request.addHeader(HttpHeaders.ACCEPT,
          "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

      request.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");

      request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");

      request.addHeader(HttpHeaders.CACHE_CONTROL, "max-age=0");


      request.addHeader("upgrade-insecure-requests:", "1");
      
      
      request.addHeader("cookie", "bm_sv=\"943615070F919BCB58A59B05528CC0ED~c/wtoKfTqiz/png99QH0ajyorYcypZWZRtIQr70HEpDB+vP3w3V/KQVTIlwWkePnxBf...\", version:0, domain:nseindia.com, path:/, expiry:null");
      
      HttpContext localContext = new BasicHttpContext();
      localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

      HttpResponse downloaded = httpClient.execute(request);



      var v = downloaded.getAllHeaders();

      log.error(v.toString());


    } catch (Exception e) {
      log.error("--error--");
      log.error(e.getMessage());
      log.error("--Tying again--");

    }



  }



  public static void download(String url, String saveFileAs) {

    CloseableHttpClient httpClient = HttpClients.createDefault();

    try {


      HttpGet request = new HttpGet(url);

      request.addHeader(HttpHeaders.USER_AGENT,
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
      request.addHeader(HttpHeaders.ACCEPT,
          "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

      request.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");

      request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");

      request.addHeader(HttpHeaders.CACHE_CONTROL, "max-age=0");


      request.addHeader("upgrade-insecure-requests:", "1");


      CloseableHttpResponse downloaded = httpClient.execute(request);

      HttpEntity entity = downloaded.getEntity();

      String fileurl = "/users/i355696/Documents//NSE-DATA/xml/xmls/" + saveFileAs + ".xml";
      File yourFile = new File(fileurl);
      yourFile.createNewFile();
      FileOutputStream fos = new FileOutputStream(fileurl);
      entity.writeTo(fos);
      fos.close();

    } catch (Exception e) {
      log.error("--error--");
      log.error(e.getMessage());
      log.error("--Tying again--");

    } finally {


      try {
        httpClient.close();
      } catch (IOException e) {
        System.out.println("------cannont close-------");
      }
      System.out.println("------finally-------");
    }

  }

}

