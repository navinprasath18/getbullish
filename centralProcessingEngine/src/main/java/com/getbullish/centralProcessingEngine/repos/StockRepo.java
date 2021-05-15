package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.Stock;

@Repository
public interface StockRepo extends Baserepo<Stock, UUID> {


}
