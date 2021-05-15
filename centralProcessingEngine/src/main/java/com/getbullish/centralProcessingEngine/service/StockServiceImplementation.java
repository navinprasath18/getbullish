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

  public void create() {

    Stock stock = new Stock();
    Sector sector =
        sectorService.getEntity(UUID.fromString("6ada0c8f-fa28-4560-b693-1e2e607741fc"));
    stock.setSector(sector);
    stock.setSecurity("name");
    stock.setSymbol("symbol");
    repo.save(stock);
  }

  public List<StockData> getAllStocks() {
    return listData();
  }


  @Override
  public BaseIdentityMapper<Stock, StockData> getBasedataMapper() {

    return mapper;
  }

}
