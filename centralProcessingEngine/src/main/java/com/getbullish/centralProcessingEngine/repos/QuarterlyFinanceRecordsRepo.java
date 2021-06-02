package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity.QuarterlyFinaceRecords;


@Repository
public interface QuarterlyFinanceRecordsRepo extends Baserepo<QuarterlyFinaceRecords, UUID> {

}
