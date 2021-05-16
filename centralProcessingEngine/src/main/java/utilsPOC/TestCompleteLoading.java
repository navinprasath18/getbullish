package utilsPOC;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCompleteLoading {
  public static void main(String args[]) {


    // readdirectory("/users/i355696/Documents/NSE-DATA/SECTORWISE");

    getFolderList();

  }


  // read a directory and returns list if csv files in the directory

  public static void readdirectory(String directory) {
    String[] pathnames;


    File f = new File(directory);


    pathnames = f.list();

    List<String> list = new ArrayList<String>();
    for (String path : pathnames) {
      String substr = path.substring(path.length() - 4);
      if (substr.equals(".csv"))
        list.add(path);
    }

    System.out.println(Arrays.toString(pathnames));
    System.out.println(pathnames);
  }

  public static void getFolderList() {
    {

      String directory = "/users/i355696/Documents/NSE-DATA/SAMPLEHISTORY/";
      String[] pathnames;

      File f = new File(directory);
      pathnames = f.list();
      List<String> list = new ArrayList<String>();

      list.addAll(Arrays.asList(pathnames));

      System.out.println(list.size());
    }


  }
}
