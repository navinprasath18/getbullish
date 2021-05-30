package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.repos.StockRepo;

@Service
public class ApchclientTest {

  @Autowired
  StockRepo repo;

  // https://www.nseindia.com/api/corporates-financial-results?index=equities&symbol=RELIANCE

  public void startdownload() {
    List<Stock> list = repo.findAll();

    String uri = "https://www.nseindia.com/api/corporates-financial-results?index=equities&symbol=";

    for (Stock stock : list) {
      String symbol = stock.getSymbol();
      String urrl = uri + symbol;
      download(urrl, symbol);

    }
  }



  public void download(String url, String saveFileAs) {

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

      request.addHeader("cookie",
          "_ga=GA1.2.1923734728.1620988702; _gid=GA1.2.245872412.1622198307; nseQuoteSymbols=[{\"symbol\":\"JUSTDIAL\",\"identifier\":null,\"type\":\"equity\"}]; RT=\"z=1&dm=nseindia.com&si=beb86349-1a21-4d13-80c7-ed35ceb46502&ss=kpa07y8s&sl=2&tt=7ka&bcn=%2F%2F684d0d3e.akstat.io%2F&ld=igdf&ul=nvs9&hd=nvsq\"; AKA_A2=A; ak_bmsc=2AC43E304DAC5D3B4D6D97566E200C2217CB3F0E19590000A285B260684EB17F~plIcajrgO+opfEvxBsUGaQdksUJH5VDRcbsyTAvLFd7/nUG2RZXqfulcg9e9LsS5kcGUS0FqumMsfsjdPjpJDHueTf/VWG3QUILGBMQF/VHam1k3R9jR8cFLAfDsNFgntGniHmgW9+vQvLuprCkuf5znL3bj2NL/6Osha/ZsrM0yO72Pqm36tKa9CPBOnLwIwo3mYSEV7nr8rjxy+AQ9l4mQ4C82U0SIEqK2b3X2c+rNw=; nsit=cygTqHWaWpYBCxubUGZtSp2X; nseappid=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhcGkubnNlIiwiYXVkIjoiYXBpLm5zZSIsImlhdCI6MTYyMjMxMzI3OCwiZXhwIjoxNjIyMzE2ODc4fQ.EUP0D_tZbGtt2u2MmetBwVVnYrlaawpHnmnt4XuP66k; bm_sv=ECA05E6254A3724C9F121DA72BBDBD05~zrlw/WaALM9ChynU+9k+pYn6n/Lnn9j4xsIUMMrLgGLQjz+BL64EegAsV2uKZEp02BC+dyfWW01ZTAhqgz7BcKa+HTPwzwpNQgTvyq6hh8Atq9LVhvrVPWv/8nbXDsVCeOxefxO3u6UH6YX6Rrn6/4qdSjN/spTYg9xQHiCWfHw=");

      System.out.println("-------------");



      CloseableHttpResponse downloaded = httpClient.execute(request);
      HttpEntity entity = downloaded.getEntity();
      System.out.println("------got file-------");
      String fileurl = "/users/i355696/Documents//NSE-DATA/xml/jsons/" + saveFileAs + ".json";
      File yourFile = new File(fileurl);
      yourFile.createNewFile();
      FileOutputStream fos = new FileOutputStream(fileurl);
      entity.writeTo(fos);
      fos.close();

    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      try {
        httpClient.close();
      } catch (IOException e) {
        System.out.println("------con not closed-------");
      }
    }


  }
}
