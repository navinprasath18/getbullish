package com.getbullish.centralProcessingEngine.repos;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.getbullish.centralProcessingEngine.Entities.Sector;

@Repository
public interface SectorRepo extends Baserepo<Sector, UUID> {


  public Sector findByNameIgnoreCase(String name);

  public Sector findBySymbolIgnoreCase(String symbol);

}
