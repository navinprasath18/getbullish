package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.QuarterlyResultsURLEntity;
import com.getbullish.centralProcessingEngine.folderHandling.FoldersAndFiles;
import com.getbullish.centralProcessingEngine.repos.QuarterlyResultsURLrepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PopulatefromNSEurltoFilingDataURL {
  @Autowired
  QuarterlyResultsURLrepo repo;

  @Autowired
  FoldersAndFiles folderservice;

  String folder = "/users/i355696/Documents/NSE-DATA/xml/jsons/";

  public void populate() {
    List<String> dir =
        folderservice.getlistoffilesInFolderAsDirectoriesWithAextention(folder, ".json");
    for (String str : dir) {
      save(str);
    }

  }



  public void save(String filedir) {


    try {
      createEntitiyListfromjson(readFile(filedir));
      log.info("------saved-----");
    } catch (IOException e) {
      log.error(e.getMessage());
    }

  }

  public void createEntitiyListfromjson(String json) {
    Gson gson = new Gson();

    Type listType = new TypeToken<List<QuarterlyResultsURLEntity>>() {}.getType();
    List<QuarterlyResultsURLEntity> quaterlyresults = gson.fromJson(json, listType);

    for (QuarterlyResultsURLEntity entity : quaterlyresults)
      try {
        repo.save(entity);
      } catch (Exception e) {

        log.info("------error-----", e.getMessage());
      }
    log.info("-----------");

  }


  public String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, StandardCharsets.US_ASCII);
  }
}
