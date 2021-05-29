package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.getbullish.centralProcessingEngine.localCSVloaders.CSVloadingUtils;
import com.getbullish.centralProcessingEngine.service.StockService;

public class UrlCSVLoader {

  @Autowired
  CSVloadingUtils csvutil;


  @Autowired
  StockService stockService;


  String url = "/users/i355696/Documents/NSE-DATA/corpfilings";
  String str = "corpfilings";


  public void loadurlcsv() {
    List<String> csv = csvutil.getCSVintheFolder(str);
    for (String str : csv) {
      Csvfile file = csvutil.getasCsvfileobj(url + "/" + str);
      process(file);
    }
  }


  public void process(Csvfile csv) {
    if (!csv.getField().get(1).equals("SYMBOL")) {
      System.out.print("Field mapping error");
      return;
    }



    List<CSVrow> row = csv.getRows();
    int i = 0;
    for (CSVrow r : row) {
      if (i++ == 0)
        continue;
      Map<Integer, String> fields = r.getFields();
      Stock stockbysymbol = stockService.findbySymbol(fields.get(3));

      if (stockbysymbol == null)
        continue;
    }


  }
}
