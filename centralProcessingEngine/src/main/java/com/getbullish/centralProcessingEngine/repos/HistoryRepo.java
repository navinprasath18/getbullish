package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.History;

@Repository
public interface HistoryRepo extends Baserepo<History, UUID> {



}