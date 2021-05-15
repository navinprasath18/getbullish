package utilsPOC;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class openCSVpoc {


  public static void main(String args[]) {

    read();

  }

  public static void read() {

    var fileName = "/users/i355696/Documents//NSE-DATA/SECTORWISE/ind_nifty500list.csv";

    try (var fr = new FileReader(fileName, StandardCharsets.UTF_8);
        var reader = new CSVReader(fr)) {

      String[] nextLine;
      int lineNumber = 0;
      while ((nextLine = reader.readNext()) != null) {
        lineNumber++;
        System.out.print("Line # " + lineNumber + " : ");
        for (var e : nextLine) {
        
          System.out.format("%-40s", e);
        }
        System.out.println("");
      }
    } catch (IOException | CsvValidationException e1) {
      System.out.print("erorororororor");
    }
  }



  public static void readdirectory() {
    String[] pathnames;

    // Creates a new File instance by converting the given pathname string
    // into an abstract pathname
    File f = new File("/users/i355696/Documents/NSE-DATA/SECTORWISE");

    // Populates the array with names of files and directories
    pathnames = f.list();

    System.out.println(Arrays.toString(pathnames));
  }


}


