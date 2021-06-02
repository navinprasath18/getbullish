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
      
      request.addHeader("if-modified-since","11 May 2020 16:44:03 GMT");

      request.addHeader("cookie","m_sv=8913D79D71F916FA2D7F971BBD071A9B~1mfYrSRfTxg7LMvwbPU9JZz+BktleFhOMhUrACAAm2JzaAkT2363Gf/fpAmrc/UK1zxv+zQ20cbFdUWQ/N4e/+zHyyVGWRaM8JMT+QC+vV1SPTgAhly5vc6hDqGK8qTWHPc7EY+VS2lw0v/Na2iN7I5JGQUrEqItLpBn6h0AVXU=; Domain=.nseindia.com; Path=/; Max-Age=6131; HttpOnly");
      CloseableHttpResponse downloaded = httpClient.execute(request);
      var headers = downloaded.getAllHeaders();
      log.info(headers.toString());
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
