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
import com.getbullish.centralProcessingEngine.Entities.QuarterlyResultsURLEntity;
import com.getbullish.centralProcessingEngine.repos.QuarterlyResultsURLrepo;
import com.getbullish.centralProcessingEngine.repos.StockRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class XMLdownloader {

  // load urls into db and this will download all xmls

  int retry = 3;

  @Autowired
  QuarterlyResultsURLrepo resultsURLRepo;



  @Autowired
  StockRepo repo;



  public void startdownload() {

    List<QuarterlyResultsURLEntity> urls = resultsURLRepo.findAll();
    for (QuarterlyResultsURLEntity entity : urls)

    {
      String filename = entity.getSymbol() + "_" + entity.getToDate() + "_" + entity.getId();
      if (!entity.getXbrl().isEmpty() && !entity.isProcessed() &&entity.getSymbol().equalsIgnoreCase("RELIANCE")) {
        download(entity.getXbrl(), filename);
        entity.setProcessed(true);
        resultsURLRepo.save(entity);
        System.out.println("------got file-------");
      }
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
      request.addHeader("cookie","_ga=GA1.2.1923734728.1620988702; _gid=GA1.2.245872412.1622198307; nseQuoteSymbols=[{\"symbol\":\"JUSTDIAL\",\"identifier\":null,\"type\":\"equity\"},{\"symbol\":\"RELIANCE\",\"identifier\":null,\"type\":\"equity\"},{\"symbol\":\"BANKNIFTY\",\"identifier\":\"OPTIDXBANKNIFTY03-06-2021PE35000.00\",\"type\":\"equity\"}]; ak_bmsc=1B6248913C662BD339408EEE2AA847F217203997407C00005196B36087B1611E~plOsbW559IxOENhQaQjln7TMzcwyHy/4eQBr1Y9CZ52RmU0lv6G7SlIclZF6NEYdhknBVjr9abYKg90YqaTEaS+QQPMTDpfWK3dFkr2psbzfKMBdUZwpaiisBpXzcLIpaby8QftR0GhZSih1PDVh5D5h9FJcUlj49yrD+lv3a4YXMOB9vxWS+gBuwJnqsa/PYKwaWeTZXSk6YkXIbMaAB0M+9YoFGbCBmNQ9iQQAC2ZqIMaN3K1kac+mtA+5fApxgY; nsit=WEMkAgMLR5iAlgfCIdA_cXxC; AKA_A2=A; _gat_UA-143761337-1=1; nseappid=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhcGkubnNlIiwiYXVkIjoiYXBpLm5zZSIsImlhdCI6MTYyMjM4NzE3NCwiZXhwIjoxNjIyMzkwNzc0fQ.R-W04qqCF8v8dyQ-pZoFeBdmdAB97KAJNYScqGlX2tw; bm_sv=FCBA9FA1456222034E14BC738D83354E~c/wtoKfTqiz/png99QH0apOjN+NarIhHVPa2e7WBdIr8rssFtsC4o1mXfhMkoh6AxUqxxPszl/SablNoEt0x4I56FsAtvVz8/hzXHn/0+RHMlYVP7ML4+qv5dl2cKn0xY2U+Aw2oNROEVF/4w/aFG3ZOMgVcIm/jccQh+MBPX+8=; RT=\"z=1&dm=nseindia.com&si=beb86349-1a21-4d13-80c7-ed35ceb46502&ss=kpbb4g1b&sl=4&tt=8ib&bcn=%2F%2F684d0d3b.akstat.io%2F&ld=b8va&ul=bhvw\"");
      CloseableHttpResponse downloaded = httpClient.execute(request);
      var headers = downloaded.getAllHeaders();
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
      if (retry > 0)
        startdownload();

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
