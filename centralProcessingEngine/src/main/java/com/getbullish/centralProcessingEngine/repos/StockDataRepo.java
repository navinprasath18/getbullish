package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.Entities.StockDataEntity;

@Repository
public interface StockDataRepo extends Baserepo<StockDataEntity, UUID> {


  StockDataEntity findByStock(Stock stock);

}
