package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Csvfile {


  String filename;

  Map<Integer, String> field = new HashMap<Integer, String>();
  List<CSVrow> rows = new ArrayList<CSVrow>();

  public void addField(int fieldNumber, String fieldname) {
    this.field.put(fieldNumber, fieldname);
  }

  public void addrow(CSVrow row) {
    rows.add(row);
  }



}
