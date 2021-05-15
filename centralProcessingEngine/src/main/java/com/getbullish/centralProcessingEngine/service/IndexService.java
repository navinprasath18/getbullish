package com.getbullish.centralProcessingEngine.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getbullish.centralProcessingEngine.data.NiftyList;
import com.getbullish.centralProcessingEngine.httpClient.nseclient.NSEclient;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IndexService {
  @Autowired
  NSEclient client;


  public void getIndex() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    NiftyList data = null;
    try {
      HttpResponse<String> response = client.getNifty200();
      data = mapper.readValue(response.body(), NiftyList.class);
      log.info(response.toString());
    } catch (IOException | InterruptedException e) {
      log.error("okhttp error");
    }
    try {
      FileOutputStream fos = new FileOutputStream("nifty50 -" + LocalDateTime.now());
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      // write object to file
      oos.writeObject(data);
      System.out.println("Done");
      // closing resources
      oos.close();
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
