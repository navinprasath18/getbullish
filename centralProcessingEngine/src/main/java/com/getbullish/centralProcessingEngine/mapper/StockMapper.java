package com.getbullish.centralProcessingEngine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.data.StockData;

@Mapper
public interface StockMapper {
  @Mapping(source = "sector.name", target = "sector")
  StockData toData(Stock entity);

  @Mapping(target = "sector", ignore = true)
  Stock toEntity(StockData data);

}
