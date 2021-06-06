package com.getbullish.centralProcessingEngine.repos;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.HistoryEntity;
import com.getbullish.centralProcessingEngine.Entities.Stock;

@Repository
public interface HistoryRepo extends Baserepo<HistoryEntity, UUID> {


  HistoryEntity findByStockAndDate(UUID id, Date date);


  List<HistoryEntity> findByStock(Stock stock);



  HistoryEntity findFirstByStockOrderByDate(Stock stock);

  HistoryEntity findFirstByStockOrderByDateDesc(Stock stock);



}
