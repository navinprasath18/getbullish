package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import java.util.Map;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.data.SectorData;

public interface SectorService extends BaseService<Sector, SectorData> {

  List<Sector> loadstaticdata();

  Sector getSectorEntity(String name);

  List<Sector> getAllSectors();

  List<Sector> saveSector(Map<String, String> map);

  void create();



}
