package com.getbullish.centralProcessingEngine.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.StockDataEntity;
import com.getbullish.centralProcessingEngine.data.StockDataDTO;
import com.getbullish.centralProcessingEngine.mapper.BaseIdentityMapper;
import com.getbullish.centralProcessingEngine.mapper.StockDataEntityMapper;
import com.getbullish.centralProcessingEngine.repos.Baserepo;
import com.getbullish.centralProcessingEngine.repos.StockDataRepo;

@Service
public class StockDataServiceImpl extends BaseServiceImpl<StockDataEntity, StockDataDTO>
    implements StockDataService {

  @Autowired
  StockDataRepo repo;

  @Autowired
  StockDataEntityMapper mapper;

  @Override
  public Baserepo<StockDataEntity, UUID> getBaseRepository() {
    return repo;
  }

  @Override
  public BaseIdentityMapper<StockDataEntity, StockDataDTO> getBasedataMapper() {
    return mapper;
  }

}
