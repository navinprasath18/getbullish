package com.getbullish.centralProcessingEngine.PopulateHistory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.LoadedFileDetails;
import com.getbullish.centralProcessingEngine.StaticData.LoaderService;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;
import com.getbullish.centralProcessingEngine.repos.LoadedFileRepo;

@Service
public class LoadHistoricData {

  @Autowired
  HistoryRepo historyRepo;


  @Autowired
  LoadedFileRepo loadedFileRepo;

  @Autowired
  LoaderService service;

  public String load() {
    List<String> list = getFolderList();
    list = getfoldersNeedtobeProcessed(list);
    List<String> directory = getDirectoriesOfEachCSV(list);
    processEachDirectoryAndSave(directory);
    return "sucess";
  }


  public List<String> getFolderList() {
    String directory = "/users/i355696/Documents/NSE-DATA/COMPLETEDATA/";
    String[] pathnames;
    File f = new File(directory);
    pathnames = f.list();
    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList(pathnames));
    return list;
  }

  public List<String> getfoldersNeedtobeProcessed(List<String> listoffolders) {
    List<String> tobePRocessed = new ArrayList<String>();
    for (String folder : listoffolders) {
      if (folder.equals(".DS_Store"))
        continue;
      LoadedFileDetails loaded = loadedFileRepo.findByFilenameIgnoreCase(folder);
      if (loaded == null) {
        LoadedFileDetails fileentity = new LoadedFileDetails();
        fileentity.setDateloaded(new Date());
        fileentity.setFilename(folder);
        fileentity.setIsLoaded(false);
        loaded = loadedFileRepo.save(fileentity);
        tobePRocessed.add(folder);
      } else {
        if (!loaded.getIsLoaded()) {
          tobePRocessed.add(folder);
        }
      }

    }
    return tobePRocessed;
  }

  public List<String> getDirectoriesOfEachCSV(List<String> list) {

    List<String> directoryList = new ArrayList<String>();
    String directory = "/users/i355696/Documents/NSE-DATA/SAMPLEHISTORY/";
    return null;
  }

  public void processEachDirectoryAndSave(List<String> list) {

  }



  public List<String> processlist(List<String> listoffolders) {

    List<String> directoryList = new ArrayList<String>();
    String directory = "/users/i355696/Documents/NSE-DATA/SAMPLEHISTORY/";

    for (String folder : listoffolders) {
      LoadedFileDetails loaded = loadedFileRepo.findByFilenameIgnoreCase(folder);
      if (loaded == null) {
        LoadedFileDetails fileentity = new LoadedFileDetails();
        fileentity.setDateloaded(new Date());
        fileentity.setFilename(folder);
        fileentity.setIsLoaded(false);
        loaded = loadedFileRepo.save(fileentity);
      }
      if (!loaded.getIsLoaded()) {

        loadIntoHistoryRepo();

      }


    }

    return directoryList;

  }

  public void loadIntoHistoryRepo() {

  }
}
