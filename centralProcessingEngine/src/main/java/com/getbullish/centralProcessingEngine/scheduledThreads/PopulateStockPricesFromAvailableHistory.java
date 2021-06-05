package com.getbullish.centralProcessingEngine.scheduledThreads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.service.HistoryService;
import com.getbullish.centralProcessingEngine.service.StockService;

@Service
public class PopulateStockPricesFromAvailableHistory {


  @Autowired
  StockService stockservice;


  @Autowired
  HistoryService historyservice;


  public void populate() {

  }



}
