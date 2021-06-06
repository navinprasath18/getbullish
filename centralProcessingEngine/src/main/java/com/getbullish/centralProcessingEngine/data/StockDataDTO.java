package com.getbullish.centralProcessingEngine.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StockDataDTO extends DataIdentity {


  /**
   * 
   */
  private static final long serialVersionUID = 1L;



  Double marketcap;

  Double price;

  Double high52week;



  Double low52week;


  Double pe;


  Double bookvalue;



  Double dividentyield;



  Double rose;


  Double roe;



  Double facevalue;


  Double gainfrom52;



  Double pricetobook;



  Double numberofscreens;


  String pros;


  String cons;

}
