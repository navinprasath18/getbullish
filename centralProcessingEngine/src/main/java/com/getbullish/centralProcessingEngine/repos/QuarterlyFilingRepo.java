package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.QuarterlyFilingJSONEntity;

@Repository
public interface QuarterlyFilingRepo extends Baserepo<QuarterlyFilingJSONEntity, UUID> {

}
