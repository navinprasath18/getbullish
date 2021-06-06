package com.getbullish.centralProcessingEngine.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StockData extends DataIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  String sector;
  String symbol;
  String security;
  String series;
  String isincode;
  StockDataDTO stockdata;

}
