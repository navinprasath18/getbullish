package com.getbullish.centralProcessingEngine.PopulateHistory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.History;
import com.getbullish.centralProcessingEngine.Entities.LoadedFileDetails;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVreader;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.getbullish.centralProcessingEngine.StaticData.LoaderService;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;
import com.getbullish.centralProcessingEngine.repos.LoadedFileRepo;
import com.getbullish.centralProcessingEngine.service.SectorService;
import com.getbullish.centralProcessingEngine.service.StockService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoadHistoricData {

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

  public String load() {
    String folderDir = "/users/i355696/Documents/NSE-DATA/SAMPLEHISTORY/";

    log.info("Getting sub folders in the directory");
    List<String> list = getFolderList(folderDir);

    log.info("Extracting folders Need to beProcessed");
    list = getfoldersNeedtobeProcessed(list);

    log.info("Getting the directories of CSV's to be loaded into repo");
    List<String> directory = getDirectoriesOfEachCSV(list, folderDir);

    log.info("Started Processing all csv's");
    processEachDirectoryAndSave(directory);

    log.info("Processing all csv's ended");
    return "sucess";
  }


  public List<String> getFolderList(String directory) {

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

  public List<String> getDirectoriesOfEachCSV(List<String> list, String dir) {
    List<String> listOfcsvDirectoriies = new ArrayList<String>();

    for (String folder : list) {

      List<String> listofFilesintheFolder = getFolderList(dir + folder);

      for (String file : listofFilesintheFolder) {
        if (file.startsWith("Pd")) {
          listOfcsvDirectoriies.add(dir + folder + "/" + file);
        }
      }
    }

    processEachDirectoryAndSave(listOfcsvDirectoriies);
    return listOfcsvDirectoriies;
  }

  public void processEachDirectoryAndSave(List<String> listOfCSVdirectories) {
    CSVreader reader = new CSVreader();
    for (String directory : listOfCSVdirectories) {
      Csvfile file = reader.readIntoCSVobject(directory);
      saveIntoRepo(file);
    }
  }

  public void saveIntoRepo(Csvfile csv) {
    if (!csv.getField().get(3).equals("SYMBOL")) {
      System.out.print("Field mapping error");
      return;
    }
    System.out.println(csv.getField());
    List<History> historyList = new ArrayList<History>();
    List<CSVrow> row = csv.getRows();
    int i = 0;
    for (CSVrow r : row) {
      if (i++ == 0)
        continue;
      Map<Integer, String> fields = r.getFields();
      // if (validateField(fields))
      // continue;
      History history = new History();
      Stock stockbysymbol = stockService.findbySymbol(fields.get(3));
      if (stockbysymbol == null)
        continue;
      history.setStockid(stockbysymbol);
      history.setPreviousClose(Double.parseDouble(fields.get(5).trim()));
      history.setOpenPrice(Double.parseDouble(fields.get(6).trim()));
      history.setHighPrice(Double.parseDouble(fields.get(7).trim()));
      history.setLowPrice(Double.parseDouble(fields.get(8).trim()));
      history.setClosePrice(Double.parseDouble(fields.get(9).trim()));
      history.setNetTradeValue(Double.parseDouble(fields.get(10).trim()));
      history.setNetTradeQuantity(Double.parseDouble(fields.get(11).trim()));
      history.setIndSEC(fields.get(12).trim());
      history.setCorpIND(fields.get(13).trim());
      history.setTrades(Double.parseDouble(fields.get(14).trim()));
      history.setHigh52week(Double.parseDouble(fields.get(15).trim()));
      history.setLow52week(Double.parseDouble(fields.get(16).trim()));
    }
  }

  public void validateFields(Map<Integer, String> fields) {

  }


  public List<String> processlist(List<String> listoffolders) {

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

  public void loadIntoHistoryRepo() {

  }
}
