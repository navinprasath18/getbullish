package com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVreader {

  public void read() {

    var fileName = "/users/i355696/Documents//NSE-DATA/SECTORWISE/ind_nifty500list.csv";

    try (var fr = new FileReader(fileName, StandardCharsets.UTF_8);
        var reader = new CSVReader(fr)) {

      String[] nextLine;
      int lineNumber = 0;
      while ((nextLine = reader.readNext()) != null) {
        lineNumber++;
        System.out.print("Line # " + lineNumber + " : ");
        for (var e : nextLine) {

          System.out.format("%-20s", e);
        }
        System.out.println("");
      }
    } catch (IOException | CsvValidationException e1) {
      System.out.print("erorororororor");
    }
  }


}
