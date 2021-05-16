package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.data.SectorData;

public interface SectorService extends BaseService<Sector, SectorData> {

  List<Sector> loadstaticdata();

  Sector getSectorEntity(String name);

}
