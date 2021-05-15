package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CSVrow {

  HashMap<Integer, String> fields = new HashMap<Integer, String>();

  public void addfields(int field, String fieldvalue) {
    this.fields.put(field, fieldvalue);
  }

}
