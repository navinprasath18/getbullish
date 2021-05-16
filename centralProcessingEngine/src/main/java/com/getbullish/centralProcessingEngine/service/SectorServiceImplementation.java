package com.getbullish.centralProcessingEngine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.StaticData.LoadSectors;
import com.getbullish.centralProcessingEngine.data.SectorData;
import com.getbullish.centralProcessingEngine.mapper.BaseIdentityMapper;
import com.getbullish.centralProcessingEngine.repos.Baserepo;
import com.getbullish.centralProcessingEngine.repos.SectorRepo;

@Service
public class SectorServiceImplementation extends BaseServiceImpl<Sector, SectorData>
    implements SectorService {

  @Autowired
  SectorRepo repo;


  @Override
  public void create() {
    Sector entity = new Sector();
    entity.setName("auto");
    entity.setSymbol("symbol");
    repo.save(entity);
  }

  @Override
  public List<Sector> getAllSectors() {
    return list();
  }

  @Override
  public Baserepo<Sector, UUID> getBaseRepository() {

    return repo;
  }

  @Override
  public BaseIdentityMapper<Sector, SectorData> getBasedataMapper() {

    return null;
  }



  // save sector
  // accepts a map<String,string> pair of sector and a short key


  @Override
  public List<Sector> saveSector(Map<String, String> map) {

    List<Sector> list = new ArrayList<Sector>();
    for (String key : map.keySet()) {

      System.out.println(key + "/" + map.get(key));

      if (repo.findByNameIgnoreCase(key) == null) {
        Sector sector = new Sector();
        sector.setName(map.get(key));
        sector.setSymbol(key);
        list.add(sector);
      }
    }
    return repo.saveAll(list);


  }

  @Override
  public List<Sector> loadstaticdata()

  {
    LoadSectors sectors = new LoadSectors();
    List<String> list = sectors.getList();
    Map<String, String> map = new HashMap<String, String>();
    for (String str : list) {
      if (str.length() > 29) {
        map.put(str.substring(0, 29), str);
      } else {
        map.put(str, str);

      }
    }

    return saveSector(map);
  }

  @Override
  public Sector getSectorEntity(String name) {
    return repo.findByNameIgnoreCase(name);
  }



}
