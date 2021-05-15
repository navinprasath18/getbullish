package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Csvfile {

  List<String> field = new ArrayList<String>();
  List<CSVrow> rows = new ArrayList<CSVrow>();

  public void addFeild(String field) {
    this.field.add(field);
  }


  public void addFeild(CSVrow row) {
    this.rows.add(row);
  }
}
