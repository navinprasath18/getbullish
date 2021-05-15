package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.LoadedFileDetails;

@Repository
public interface LoadedFileRepo extends Baserepo<LoadedFileDetails, UUID> {

}
