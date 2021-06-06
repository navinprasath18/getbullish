package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.data.StockData;
import com.getbullish.centralProcessingEngine.mapper.BaseIdentityMapper;
import com.getbullish.centralProcessingEngine.mapper.StockMapper;
import com.getbullish.centralProcessingEngine.repos.Baserepo;
import com.getbullish.centralProcessingEngine.repos.StockRepo;

@Service
public class StockServiceImplementation extends BaseServiceImpl<Stock, StockData>
    implements StockService {


  @Autowired
  StockRepo repo;


  @Autowired
  SectorServiceImplementation sectorService;


  @Autowired
  StockMapper mapper;


  @Override
  public Baserepo<Stock, UUID> getBaseRepository() {

    return repo;
  }


  public void createNewStock(Stock stock) {
    repo.save(stock);
  }

  @Override
  public void create() {

    Stock stock = new Stock();
    Sector sector =
        sectorService.getEntity(UUID.fromString("6ada0c8f-fa28-4560-b693-1e2e607741fc"));
    stock.setSector(sector);
    stock.setSecurity("name");
    stock.setSymbol("symbol");
    repo.save(stock);
  }

  @Override
  public List<StockData> getAllStocks() {
    return listData();
  }


  @Override
  public BaseIdentityMapper<Stock, StockData> getBasedataMapper() {

    return mapper;
  }

  @Override
  public List<Stock> saveall(List<Stock> data) {
    return repo.saveAll(data);
  }

  @Override
  public Stock findbySymbolAndId(String symbol, String Id) {
    return repo.findBySymbolAndIsincodeIgnoreCase(symbol, Id);
  }

  @Override
  public Stock findbySymbol(String symbol) {
    return repo.findBySymbolIgnoreCase(symbol);
  }

  @Override

  public Stock findbyISINid(String isinid) {
    return repo.findByIsincodeIgnoreCase(isinid);
  }
  
  @Override
  public StockData getbySymbol(String symbol) {
    
    return mapToData(repo.findBySymbolIgnoreCase(symbol));
    

  }

}
