package com.getbullish.centralProcessingEngine.data;

import java.util.Date;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HistoryData extends DataIdentity {



  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  double previousClose;


  double openPrice;


  double highPrice;


  double lowPrice;


  double closePrice;

  double netTradeValue;


  double netTradeQuantity;


  String indSEC;


  String corpIND;

  double trades;


  double high52week;


  double low52week;


  String series;


  Stock stockid;

  Date date;

}
