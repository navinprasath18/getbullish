package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import com.getbullish.centralProcessingEngine.Entities.HistoryEntity;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.data.HistoryData;

public interface HistoryService extends BaseService<HistoryEntity, HistoryData> {

  List<HistoryEntity> listHistory();

  List<HistoryEntity> getHistoryListByStock(Stock stock);

}
