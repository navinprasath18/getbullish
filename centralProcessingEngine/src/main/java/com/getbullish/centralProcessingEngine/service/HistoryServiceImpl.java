package com.getbullish.centralProcessingEngine.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.Entities.HistoryEntity;
import com.getbullish.centralProcessingEngine.data.HistoryData;
import com.getbullish.centralProcessingEngine.mapper.BaseIdentityMapper;
import com.getbullish.centralProcessingEngine.repos.Baserepo;
import com.getbullish.centralProcessingEngine.repos.HistoryRepo;

@Service
public class HistoryServiceImpl extends BaseServiceImpl<HistoryEntity, HistoryData>
    implements HistoryService {

  @Autowired
  HistoryRepo repo;

  @Override
  public Baserepo<HistoryEntity, UUID> getBaseRepository() {

    return repo;
  }

  @Override
  public BaseIdentityMapper<HistoryEntity, HistoryData> getBasedataMapper() {

    return null;
  }

}
