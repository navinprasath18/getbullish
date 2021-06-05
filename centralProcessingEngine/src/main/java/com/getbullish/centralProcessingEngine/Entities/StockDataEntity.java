package com.getbullish.centralProcessingEngine.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "stocksdata")
@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class StockDataEntity extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "stock", nullable = false)
  Stock stock;

  @Column(name = "marketcap")
  Double marketcap;

  @Column(name = "price")
  Double price;

  @Column(name = "high52week")
  Double high52week;


  @Column(name = "low52week")
  Double low52week;

  @Column(name = "pe")
  Double pe;

  @Column(name = "bookvalue")
  Double bookvalue;


  @Column(name = "dividentyield")
  Double dividentyield;


  @Column(name = "rose")
  Double rose;

  @Column(name = "roe")
  Double roe;


  @Column(name = "facevalue")
  Double facevalue;

  @Column(name = "gainfrom52")
  Double gainfrom52;


  @Column(name = "pricetobook")
  Double pricetobook;


  @Column(name = "numberofscreens")
  Double numberofscreens;

  @Column(name = "pros")
  String pros;

  @Column(name = "cons")
  String cons;

}
