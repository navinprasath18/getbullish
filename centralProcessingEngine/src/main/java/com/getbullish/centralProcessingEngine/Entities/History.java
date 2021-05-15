package com.getbullish.centralProcessingEngine.Entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "history")
@Getter
@Setter
@ToString(includeFieldNames = true)
public class History extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name = "PREV_CL_PR")
  long previousClose;

  @Column(name = "OPEN_PRICE")
  long openPrice;

  @Column(name = "HIGH_PRICE")
  long highPrice;

  @Column(name = "LOW_PRICE")
  long lowPrice;

  @Column(name = "CLOSE_PRICE")
  long closePrice;

  @Column(name = "NET_TRDVAL")
  long netTradeValue;

  @Column(name = "NET_TRDQTY")
  long netTradeQuantity;

  @Column(name = "IND_SEC")
  String indSEC;

  @Column(name = "CORP_IND")
  String corpIND;

  @Column(name = "TRADES")
  long trades;

  @Column(name = "HI_52_WK")
  long high52week;

  @Column(name = "LO_52_WK")
  long low52week;


  UUID stockid;
  Date date;

}
