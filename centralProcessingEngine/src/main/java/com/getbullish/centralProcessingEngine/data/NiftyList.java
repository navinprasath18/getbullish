package com.getbullish.centralProcessingEngine.data;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NiftyList {
  private String name;
  private Advance AdvanceObject;
  private String timestamp;
  ArrayList<StockData> data = new ArrayList<StockData>();

}
