package utilsPOC;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Downloader {


  public static void main(String args[]) {

    download2();



  }


  public static void download2() {

    for (int i = 3000; i < 4500; i++) {
      String file = generateFilename(-i);
      try (BufferedInputStream in = new BufferedInputStream(
          new URL("https://www1.nseindia.com/archives/equities/bhavcopy/pr/" + file).openStream());
          FileOutputStream fileOutputStream = new FileOutputStream(file)) {
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
          fileOutputStream.write(dataBuffer, 0, bytesRead);
        }

      } catch (MalformedURLException e) {
        System.out.println("--skipped----" + file);
      } catch (IOException e) {
        System.out.println("--skipped----" + file);
      }
      System.out.println(file + ": downloaded file no: " + i);
    }
  }

  public static String generateFilename(int days) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, days);
    Date date = cal.getTime();
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
    String strDate = formatter.format(date);
    String zipfile = "PR" + strDate + ".zip";
    System.out.println(zipfile);
    return zipfile;
  }
}


// PR200109.zip: downloaded file no: 4498
// PR190109.zip
// --skipped----PR190109.zip
// PR190109.zip: downloaded file no: 4499
