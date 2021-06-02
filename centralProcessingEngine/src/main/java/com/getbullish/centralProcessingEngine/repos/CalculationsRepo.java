package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.LoadedFileDetails;
import com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity.Calculations;



  @Repository
  public interface CalculationsRepo extends Baserepo<Calculations, UUID> {
}
