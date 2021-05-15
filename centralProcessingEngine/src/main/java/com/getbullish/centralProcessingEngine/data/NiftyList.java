package com.getbullish.centralProcessingEngine.data;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NiftyList implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String name;
  private Advance AdvanceObject;
  private String timestamp;
  ArrayList<StockHistoryData> data = new ArrayList<StockHistoryData>();

}
