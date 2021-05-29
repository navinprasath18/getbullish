package utilsPOC;

import com.getbullish.centralProcessingEngine.localCSVloaders.CSVloadingUtils;

public class TestinMainClass {

  public static void main(String args[]) {
    String url = "/users/i355696/Documents/NSE-DATA/SAMPLEHISTORY/PR140521";
    CSVloadingUtils utobj = new CSVloadingUtils();
    System.out.print(utobj.getCSVintheFolder(url));

  }

}
