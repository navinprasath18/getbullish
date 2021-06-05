package com.getbullish.centralProcessingEngine.multithreadedLoader;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.HistoryEntity;
import com.getbullish.centralProcessingEngine.Entities.LoadedFileDetails;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVreader;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;
import com.getbullish.centralProcessingEngine.repos.LoadedFileRepo;
import com.getbullish.centralProcessingEngine.service.StockService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessAndSaveService {


  @Autowired
  LoadedFileRepo loadedFileRepo;

  @Autowired
  HistoryRepo historyRepo;


  @Autowired
  StockService stockService;


  @Async("historyloaderbean")
  public void processEachDirectoryAndSave(String CSVdirectory) {
    log.info("**** " + CSVdirectory + "loading **** ");
    CSVreader reader = new CSVreader();
    Csvfile file = reader.readIntoCSVobject(CSVdirectory);
    File f = new File(CSVdirectory);
    file.setFilename(f.getName());
    saveIntoRepo(file);

  }


  public void saveIntoRepo(Csvfile csv) {
    if (!csv.getField().get(3).equals("SYMBOL")) {
      System.out.print("Field mapping error");
      return;
    }

    List<HistoryEntity> historyList = new ArrayList<HistoryEntity>();
    List<CSVrow> row = csv.getRows();
    int i = 0;
    for (CSVrow r : row) {
      if (i++ == 0)
        continue;
      Map<Integer, String> fields = r.getFields();

      HistoryEntity history = new HistoryEntity();
      Stock stockbysymbol = stockService.findbySymbol(fields.get(3));
      if (stockbysymbol == null)
        continue;
      // String string = "PR" + csv.getFilename().substring(2, 8);

      LoadedFileDetails loaded =
          loadedFileRepo.findByFilenameIgnoreCase("PR" + csv.getFilename().substring(2, 8));
      if (loaded == null)
        continue;
      history.setDate(calculateDate(csv.getFilename()));
      history.setStock(stockbysymbol);
      history.setSeries(fields.get(2).trim());
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
      historyList.add(history);
      loaded.setIsLoaded(true);
      loadedFileRepo.save(loaded);
    }
    try {
      historyRepo.saveAll(historyList);
    } catch (Exception e) {
      System.out.println("Someething went wring" + e.getMessage());

    }
    //
    log.info("Done loading" + csv.getFilename());
  }



  public Date calculateDate(String str) {

    SimpleDateFormat sdf = new SimpleDateFormat("ddmmyy");
    Date date;
    try {
      date = sdf.parse(str.substring(2));
    } catch (ParseException e) {
      return null;
    }
    return date;

  }

}
