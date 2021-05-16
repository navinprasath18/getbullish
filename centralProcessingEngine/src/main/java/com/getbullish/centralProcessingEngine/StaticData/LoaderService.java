package com.getbullish.centralProcessingEngine.StaticData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVreader;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.getbullish.centralProcessingEngine.service.SectorService;
import com.getbullish.centralProcessingEngine.service.StockService;

@Service
public class LoaderService {

  @Autowired
  StockService stockService;

  @Autowired
  SectorService service;



  public List<Stock> loadStaticdata() {

    CSVreader reader = new CSVreader();
    Csvfile file = reader
        .readIntoCSVobject("/users/i355696/Documents//NSE-DATA/SECTORWISE/ind_nifty500list.csv");
    return stockEntityprocessor(file);


  }


  public String loadAllCSVFilesInDirectory() {
    String directory = "/users/i355696/Documents/NSE-DATA/SECTORWISE/";
    List<String> listofcsv = getCSVlist(directory);
    for (String csv : listofcsv) {
      CSVreader reader = new CSVreader();
      Csvfile file = reader.readIntoCSVobject(directory + csv);
      stockEntityprocessor(file);
    }

    return "success";


  }



  public List<Stock> stockEntityprocessor(Csvfile csv) {


    if (!csv.getField().get(1).equals("Company Name")) {
      System.out.print("Field mapping error");
      return null;
    }
    System.out.println(csv.getField());
    List<Stock> stocklist = new ArrayList<Stock>();
    List<CSVrow> row = csv.getRows();
    int i = 0;
    for (CSVrow r : row) {
      if (i++ == 0)
        continue;
      Map<Integer, String> fields = r.getFields();
      if (validateField(fields))
        continue;
      Stock stock = new Stock();
      stock.setIsincode(fields.get(5));
      stock.setSecurity(fields.get(1));
      stock.setSeries(fields.get(4));
      Sector sec = service.getSectorEntity(fields.get(2));
      if (sec == null) {
        System.out.print(fields.get(2));
        sec = service.getSectorEntity("FIND THE SECTOR");
      }
      stock.setSector(sec);
      stock.setSymbol(fields.get(3));
      stocklist.add(stock);
    }
    return stockService.saveall(stocklist);

  }

  public Boolean validateField(Map<Integer, String> fields) {
    Stock stockbysymbol = stockService.findbySymbol(fields.get(3));
    Stock stockbyISIN = stockService.findbyISINid(fields.get(5));
    if (stockbysymbol != null || stockbyISIN != null)
      return true;
    return false;

  }


  public List<String> getCSVlist(String directory) {
    String[] pathnames;


    File f = new File(directory);


    pathnames = f.list();

    List<String> list = new ArrayList<String>();
    for (String path : pathnames) {
      String substr = path.substring(path.length() - 4);
      if (substr.equals(".csv"))
        list.add(path);
    }

    return list;

  }
}
