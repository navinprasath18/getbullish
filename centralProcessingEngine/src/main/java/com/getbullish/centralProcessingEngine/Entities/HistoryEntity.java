package com.getbullish.centralProcessingEngine.Entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "history")
@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class HistoryEntity extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name = "PREV_CL_PR")
  double previousClose;

  @Column(name = "OPEN_PRICE")
  double openPrice;

  @Column(name = "HIGH_PRICE")
  double highPrice;

  @Column(name = "LOW_PRICE")
  double lowPrice;

  @Column(name = "CLOSE_PRICE")
  double closePrice;

  @Column(name = "NET_TRDVAL")
  double netTradeValue;

  @Column(name = "NET_TRDQTY")
  double netTradeQuantity;

  @Column(name = "IND_SEC")
  String indSEC;

  @Column(name = "CORP_IND")
  String corpIND;

  @Column(name = "TRADES")
  double trades;

  @Column(name = "HI_52_WK")
  double high52week;

  @Column(name = "LO_52_WK")
  double low52week;

  @Column(name = "series")
  String series;

  @OneToOne
  @JoinColumn(name = "stock", nullable = false)
  Stock stock;

  @Column(name = "date")
  Date date;

}
