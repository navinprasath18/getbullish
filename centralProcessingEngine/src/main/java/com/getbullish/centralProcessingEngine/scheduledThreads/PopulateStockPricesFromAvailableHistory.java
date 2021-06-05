package com.getbullish.centralProcessingEngine.scheduledThreads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.HistoryEntity;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.Entities.StockDataEntity;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;
import com.getbullish.centralProcessingEngine.service.HistoryService;
import com.getbullish.centralProcessingEngine.service.StockService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PopulateStockPricesFromAvailableHistory {


  @Autowired
  StockService stockservice;


  @Autowired
  HistoryService historyservice;



  @Autowired
  HistoryRepo historyrepo;


  public void populate() {


    Stock stock = stockservice.findbySymbol("RELIANCE");
    StockDataEntity entity = new StockDataEntity();

    var history = historyservice.getHistoryListByStock(stock);

    log.info("#Histry --Count :" + history.size());

    HistoryEntity lastknown = historyrepo.findFirstByStockOrderByDateDesc(stock);
    log.info("-----" + lastknown.getDate());


  }



}
