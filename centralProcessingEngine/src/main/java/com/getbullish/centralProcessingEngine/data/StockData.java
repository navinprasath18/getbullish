package com.getbullish.centralProcessingEngine.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockData {

  private float priority;
  private String symbol;
  private String identifier;
  private String series;
  private float open;
  private float dayHigh;
  private float dayLow;
  private float lastPrice;
  private float previousClose;
  private float change;
  private float pChange;
  private float totalTradedVolume;
  private float totalTradedValue;
  private String lastUpdateTime;
  private float yearHigh;
  private float ffmc;
  private float yearLow;
  private float nearWKH;
  private float nearWKL;
  private float perChange365d;
  private String date365dAgo;
  private String chart365dPath;
  private String date30dAgo;
  private float perChange30d;
  private String chart30dPath;
  private String chartTodayPath;
  private Meta meta;

}
