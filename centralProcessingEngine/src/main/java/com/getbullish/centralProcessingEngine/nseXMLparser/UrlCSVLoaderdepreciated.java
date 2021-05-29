package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.QuarterlyResultsURLEntity;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.getbullish.centralProcessingEngine.localCSVloaders.CSVloadingUtils;
import com.getbullish.centralProcessingEngine.repos.QuarterlyResultsURLrepo;
import com.getbullish.centralProcessingEngine.service.StockService;

@Service
public class UrlCSVLoaderdepreciated {

  @Autowired
  CSVloadingUtils csvutil;


  @Autowired
  StockService stockService;


  @Autowired
  QuarterlyResultsURLrepo repo;


  String url = "/users/i355696/Documents/NSE-DATA/corpfilings";
  String str = "corpfilings";


  public void loadurlcsv() {
    List<String> csv = csvutil.getCSVintheFolder(url);
    for (String str : csv) {
      Csvfile file = csvutil.getasCsvfileobj(url + "/" + str);
      process(file);
    }
  }


  public void process(Csvfile csv) {



    List<CSVrow> row = csv.getRows();
    int i = 0;
    for (CSVrow r : row) {
      if (i++ == 0)
        continue;
      QuarterlyResultsURLEntity entity = new QuarterlyResultsURLEntity();
      Map<Integer, String> fields = r.getFields();
      entity.setAudited(fields.get(2));
      entity.setCompanyName(fields.get(1));
      entity.setConsolidated(fields.get(4));
      entity.setCumulative(fields.get(3));
      entity.setPeriod(fields.get(6));
      entity.setToDate(fields.get(7));
      entity.setXbrl(fields.get(9));
      entity.setRelatingTo(fields.get(8));
      entity.setIndAs(fields.get(5));
      try {
        repo.save(entity);
      } catch (Exception e) {
        System.out.println("----Unable to store----");
      }
    }



  }

  // {1=﻿COMPANY NAME, 2=AUDITED / UNAUDITED, 3=CUMULATIVE / NON-CUMULATIVE, 4=CONSOLIDATED /
  // NON-CONSOLIDATED, 5=IND AS/ NON IND AS, 6=PERIOD, 7=PERIOD ENDED, 8=RELATING TO, 9=** XBRL}
}
