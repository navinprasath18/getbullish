package com.getbullish.centralProcessingEngine.nseXMLparser;


import java.lang.reflect.InvocationTargetException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.QuarterlyFilingJSONEntity;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity.Quarter;
import com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity.QuarterlyFinaceRecords;
import com.getbullish.centralProcessingEngine.repos.QuarterlyFilingRepo;
import com.getbullish.centralProcessingEngine.repos.QuarterlyFinanceRecordsRepo;
import com.getbullish.centralProcessingEngine.service.StockService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessJSONintoDBFields {

  @Autowired
  StockService stockserv;
  @Autowired
  QuarterlyFilingRepo filingrepo;


  @Autowired
  QuarterlyFinanceRecordsRepo repo;



  public void processJSONintoEntity() {
    List<QuarterlyFilingJSONEntity> list = filingrepo.findAll();
    List<QuarterlyFinaceRecords> financerecords = new ArrayList<QuarterlyFinaceRecords>();

    for (QuarterlyFilingJSONEntity entity : list) {
      String str = entity.getJson();

      JSONObject json = (JSONObject) new JSONObject(str).get("xbrli:xbrl");

      JSONObject symbol = (JSONObject) json.get("in-bse-fin:Symbol");

      Stock stock = stockserv.findbySymbol(symbol.getString("content"));


      Map<String, String> map = getasmap(json);

      // for (String str2 : map.keySet()) {
      // log.info(str2 + "---" + map.get(str2));
      //
      // }

      log.info("===");
      QuarterlyFinaceRecords finrec = new QuarterlyFinaceRecords();
      try {
        finrec = setter(finrec, map);
      } catch (Exception e) {
        log.error("---ERROR--- :" + e.getMessage());
        continue;
      }
      finrec.setStock(stock);
      finrec = validateAndTag(finrec, map);
//      QuarterlyFinaceRecords ispresent =
//          repo.findByStockAndQuarterAndYearAndCumulativeAndConsolidatedAndAudited(stock,
//              finrec.getQuarter(), finrec.getYear(), finrec.isCumulative(), finrec.isConsolidated(),
//              finrec.isAudited());
 //     if (ispresent != null)
        repo.save(finrec);
    }
  }


  public Map<String, String> getasmap(JSONObject obj) {
    Map<String, String> map = new TreeMap<String, String>();
    for (String str : obj.keySet()) {
      map.put(processkey(str), proceessValue(str, obj.get(str)));

    }
    return map;

  }

  String processkey(String keystr) {

    if (keystr.startsWith("in-bse-fin:")) {
      keystr = keystr.substring(11);
      keystr = keystr.substring(0, 1).toLowerCase() + keystr.substring(1);
    }
    if (keystr.length() > 60)
      keystr = keystr.substring(0, 60);
    return keystr;


  }

  String proceessValue(String key, Object value) {
    if (key.startsWith("in-bse-fin:")) {

      if (value instanceof JSONObject) {
        try {
          JSONObject obj = (JSONObject) value;
          return obj.get("content").toString();
        } catch (Exception e) {
          log.error("--Error retriving :" + key + e.getMessage());
          return "";
        }

      }



    } else {
      log.error(key + " is of class " + value.getClass().toString());
    }
    return null;
  }



  public QuarterlyFinaceRecords setter(QuarterlyFinaceRecords rec, Map<String, String> map)
      throws IllegalAccessException, InvocationTargetException {
    DateTimeConverter dtConverter = new DateConverter();
    dtConverter.setPattern("yyyy-mm-dd");
    ConvertUtils.register(dtConverter, Date.class);

    for (String str : map.keySet()) {
      BeanUtils.setProperty(rec, str, map.get(str));
    }
    return rec;
  }

  public QuarterlyFinaceRecords validateAndTag(QuarterlyFinaceRecords finrec,
      Map<String, String> map) {

    finrec.setQuarter(getquarter(map.get("reportingQuarter")));

    finrec.setYear(Year.now());
    finrec.setAudited(true);
    finrec.setCumulative(true);

    return finrec;
  }

  public Quarter getquarter(String quarter) {
    switch (quarter) {
      case "First quarter":
        return Quarter.MARCH;
      case "Second quarter":
        return Quarter.JUNE;
      case "Third quarter":
        return Quarter.SEPTEMBER;
      case "Fourth quarter":
        return Quarter.DECEMBER;
    }
    return null;

  }


}
