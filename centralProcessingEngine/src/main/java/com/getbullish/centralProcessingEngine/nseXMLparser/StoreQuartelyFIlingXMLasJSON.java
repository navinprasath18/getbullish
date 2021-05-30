package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.QuarterlyFilingJSONEntity;
import com.getbullish.centralProcessingEngine.repos.QuarterlyFilingRepo;
import com.getbullish.centralProcessingEngine.repos.StockRepo;
import com.getbullish.centralProcessingEngine.service.StockService;
import lombok.extern.slf4j.Slf4j;
// store xmls as json into the db

@Service
@Slf4j
public class StoreQuartelyFIlingXMLasJSON {



  @Autowired
  QuarterlyFilingRepo repo;


  @Autowired
  StockRepo stockrepo;


  @Autowired
  StockService stockserv;



  public void store() {

    String xml;
    try {
      xml = readFile("/users/i355696/Documents/NSE-DATA/xml/samplexml/1.xml");
      parse(xml);
    } catch (IOException e) {
      System.out.print("----error------");
    }


  }

  public void parse(String xml) {

    JSONObject xmlJSONObj = XML.toJSONObject(xml);
    JSONObject json = (JSONObject) xmlJSONObj.get("xbrli:xbrl");
    JSONObject symbol = (JSONObject) json.get("in-bse-fin:Symbol");
    QuarterlyFilingJSONEntity entity = new QuarterlyFilingJSONEntity();

    entity.setStock(stockserv.findbySymbol(symbol.getString("content")));
    entity.setJson(xmlJSONObj.toString());
    log.info("------a json processed-----");
    repo.save(entity);

  }



  public static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, StandardCharsets.US_ASCII);
  }


}
