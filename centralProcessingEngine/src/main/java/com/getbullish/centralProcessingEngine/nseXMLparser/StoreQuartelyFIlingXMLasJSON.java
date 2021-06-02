package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.QuarterlyFilingJSONEntity;
import com.getbullish.centralProcessingEngine.folderHandling.FoldersAndFiles;
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

  @Autowired
  FoldersAndFiles folderser;



  public void store() {



    var directory = "/users/i355696/Documents/NSE-DATA/xml/xmls/";

    var map = folderser.getlistofAllfilesInFolderAsDirectoriesWithName(directory);



    for (Map.Entry<String, String> entry : map.entrySet()) {

      String xml;
      try {
        xml = readFile(entry.getValue());
        parse(xml, entry.getKey());
      } catch (IOException e) {
        System.out.print("----error------");
      }

    }
  }

  public void parse(String xml, String filename) {
    try {
      JSONObject xmlJSONObj = XML.toJSONObject(xml);
      JSONObject json = (JSONObject) xmlJSONObj.get("xbrli:xbrl");
      JSONObject symbol = (JSONObject) json.get("in-bse-fin:Symbol");
      QuarterlyFilingJSONEntity entity = new QuarterlyFilingJSONEntity();

      entity.setStock(stockserv.findbySymbol(symbol.getString("content")));
      entity.setJson(xmlJSONObj.toString());
      entity.setXmlfilename(filename);
      log.info("------a json processed-----");
      repo.save(entity);

    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }


  public static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, StandardCharsets.US_ASCII);
  }


}
