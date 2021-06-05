package com.getbullish.centralProcessingEngine.multithreadedLoader;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.LoadedFileDetails;
import com.getbullish.centralProcessingEngine.StaticData.LoaderService;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;
import com.getbullish.centralProcessingEngine.repos.LoadedFileRepo;
import com.getbullish.centralProcessingEngine.service.SectorService;
import com.getbullish.centralProcessingEngine.service.StockService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CSVfinderService {


  @Autowired
  HistoryRepo historyRepo;
  @Autowired
  StockService stockService;

  @Autowired
  SectorService sectorservice;

  @Autowired
  LoadedFileRepo loadedFileRepo;

  @Autowired
  LoaderService service;

  public List<String> get() {
    // String folderDir = "/users/i355696/Documents/NSE-DATA/SAMPLEHISTORY/";

    String folderDir = "/users/i355696/Documents/NSE-DATA/COMPLETEDATA/";

    log.info("Getting sub folders in the directory");
    List<String> list = getFolderList(folderDir);

    log.info("Extracting folders Need to beProcessed");
    list = getfoldersNeedtobeProcessed(list);

    log.info("Getting the directories of CSV's to be loaded into repo");
    List<String> directory = getDirectoriesOfEachCSV(list, folderDir);
    return directory;


  }


  private List<String> getFolderList(String directory) {

    String[] pathnames;
    File f = new File(directory);
    pathnames = f.list();
    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList(pathnames));
    return list;
  }

  private List<String> getfoldersNeedtobeProcessed(List<String> listoffolders) {
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

  private List<String> getDirectoriesOfEachCSV(List<String> list, String dir) {
    List<String> listOfcsvDirectoriies = new ArrayList<String>();

    for (String folder : list) {

      List<String> listofFilesintheFolder = getFolderList(dir + folder);

      for (String file : listofFilesintheFolder) {
        if (file.startsWith("Pd")) {
          listOfcsvDirectoriies.add(dir + folder + "/" + file);
        }
      }
    }


    return listOfcsvDirectoriies;
  }



  @SuppressWarnings("unused")
  private void validateFields(Map<Integer, String> fields) {

  }



  @SuppressWarnings("unused")
  private List<String> processlist(List<String> listoffolders) {

    List<String> directoryList = new ArrayList<String>();

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

  private void loadIntoHistoryRepo() {

  }

}
