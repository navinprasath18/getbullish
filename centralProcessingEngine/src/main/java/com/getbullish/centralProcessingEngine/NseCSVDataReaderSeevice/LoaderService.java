package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.Entities.Stock;
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
      Stock stock = new Stock();
      stock.setIsincode(fields.get(5));
      stock.setSecurity(fields.get(1));
      stock.setSeries(fields.get(4));
      Sector sec = service.getSectorEntity(fields.get(2));
      if (sec == null) {
        System.out.print(fields.get(2));
      }
      stock.setSector(sec);
      stock.setSymbol(fields.get(3));
      stocklist.add(stock);
    }
    return stockService.saveall(stocklist);

  }



}
