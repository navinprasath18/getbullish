package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.getbullish.centralProcessingEngine.service.StockService;

@Service
public class LoaderService {

  @Autowired
  StockService stockService;



  public List<Stock> loadStaticdata() {

    CSVreader reader = new CSVreader();
    Csvfile file = reader
        .readIntoCSVobject("/users/i355696/Documents//NSE-DATA/SECTORWISE/ind_nifty500list.csv");
    return stockEntityprocessor(file);


  }


  public List<Stock> stockEntityprocessor(Csvfile csv) {


    if (csv.getField().get(1) != "Company Name") {
      System.out.print("Field mapping error");
      return null;
    }
    List<Stock> stocklist = new ArrayList<Stock>();
    List<CSVrow> row = csv.getRows();
    for (CSVrow r : row) {
      Map<Integer, String> fields = csv.getField();
      Stock stock = new Stock();
      stock.setIsin_code(fields.get(1));
      stock.setSecurity(fields.get(1));
      stock.setSeries(fields.get(1));
      stock.setSymbol(fields.get(3));
      stocklist.add(stock);
    }
    return stockService.saveall(stocklist);

  }


}
