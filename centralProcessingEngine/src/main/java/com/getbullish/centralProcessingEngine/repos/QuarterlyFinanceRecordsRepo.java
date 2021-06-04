package com.getbullish.centralProcessingEngine.repos;

import java.time.Year;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity.Quarter;
import com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity.QuarterlyFinaceRecords;


@Repository
public interface QuarterlyFinanceRecordsRepo extends Baserepo<QuarterlyFinaceRecords, UUID> {


  public QuarterlyFinaceRecords findByStockAndQuarterAndYearAndCumulativeAndConsolidatedAndAudited(
      Stock stock, Quarter quarter, Year year, Boolean cumulative, Boolean consolidated,
      Boolean audited);

}
