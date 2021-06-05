package com.getbullish.centralProcessingEngine.scheduledThreads;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.HistoryEntity;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.Entities.StockDataEntity;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;
import com.getbullish.centralProcessingEngine.repos.StockDataRepo;
import com.getbullish.centralProcessingEngine.repos.StockRepo;
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

  @Autowired
  StockDataRepo stockdatarepo;


  @Autowired
  StockRepo stockrepo;


  public void populate() {



    List<Stock> stocks = stockrepo.findAll();
    log.info("---Stocks-- :" + stocks.size());

    for (Stock stock : stocks) {
      try {

        StockDataEntity stockdataentity = stockdatarepo.findByStock(stock);
        if (stockdataentity == null)
          stockdataentity = new StockDataEntity();

        HistoryEntity lastknown = historyrepo.findFirstByStockOrderByDateDesc(stock);
        stockdataentity.setStock(stock);
        stockdataentity.setHigh52week(lastknown.getHigh52week());
        stockdataentity.setLow52week(lastknown.getLow52week());
        stockdataentity.setPrice(lastknown.getClosePrice());
        stockdatarepo.save(stockdataentity);
        // log.info("-----" + lastknown.getDate());
      } catch (Exception e) {

        log.error("==#ERROR== :" + e.getMessage());

      }


    }
  }
}
