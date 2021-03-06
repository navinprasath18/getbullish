package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.data.StockData;

public interface StockService extends BaseService<Stock, StockData> {

  List<StockData> getAllStocks();

  void create();

  List<Stock> saveall(List<Stock> data);

  Stock findbySymbolAndId(String symbol, String Id);

  Stock findbySymbol(String namee);

  Stock findbyISINid(String isinid);

  StockData getbySymbol(String symbol);

}
