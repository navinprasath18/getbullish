package com.getbullish.centralProcessingEngine.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StockData extends DataIdentity {

  String sector;
  String symbol;
  String security;

}
