package com.getbullish.centralProcessingEngine.mapper;

import org.mapstruct.Mapper;
import com.getbullish.centralProcessingEngine.Entities.StockDataEntity;
import com.getbullish.centralProcessingEngine.data.StockDataDTO;

@Mapper(componentModel = "spring")
public interface StockDataEntityMapper extends BaseIdentityMapper<StockDataEntity, StockDataDTO> {

}
