package utilsPOC;

import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVreader;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;

public class TestReader {

  public static void main(String args[]) {

    CSVreader reader = new CSVreader();
    Csvfile file = reader
        .readIntoCSVobject("/users/i355696/Documents//NSE-DATA/SECTORWISE/ind_nifty500list.csv");

    System.out.print("done");
    System.out.print(file.getField().toString());

  }

}
