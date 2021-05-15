package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.CSVrow;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVreader {


  public Csvfile readIntoCSVobject(String fileName) {

    // var fileName = "/users/i355696/Documents//NSE-DATA/SECTORWISE/ind_nifty500list.csv";
    Csvfile file = new Csvfile();
    try (var fr = new FileReader(fileName, StandardCharsets.UTF_8);
        var reader = new CSVReader(fr)) {

      String[] nextLine;
      int lineNumber = 1;
      int fieldFlag = 1;
      while ((nextLine = reader.readNext()) != null) {
        CSVrow row = new CSVrow();
        for (var e : nextLine) {
          if (lineNumber == 1) {
            file.addField(fieldFlag++, e);
          } else {
            row.addfields(fieldFlag++, e);
          }
        }
        lineNumber++;
        fieldFlag = 1;
        file.addrow(row);
      }

    } catch (IOException | CsvValidationException e1) {
      System.out.print("erorororororor");
    }
    return file;
  }


}
