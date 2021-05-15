package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.repos.Baserepo;
import com.getbullish.centralProcessingEngine.repos.SectorRepo;

@Service
public class SectorService extends BaseServiceImpl<Sector> {

  @Autowired
  SectorRepo repo;

  public void create() {
    Sector entity = new Sector();
    entity.setName("auto");
    entity.setSymbol("symbol");
    repo.save(entity);
  }

  public List<Sector> getAllSectors() {
    return list();
  }

  @Override
  public Baserepo<Sector, UUID> getBaseRepository() {

    return repo;
  }

}
