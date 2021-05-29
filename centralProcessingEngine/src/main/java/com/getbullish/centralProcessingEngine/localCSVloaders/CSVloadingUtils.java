package com.getbullish.centralProcessingEngine.localCSVloaders;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVreader;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.CSVData.Csvfile;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CSVloadingUtils {



  public List<String> getCSVintheFolder(String folderdirectory) {

    File f = new File(folderdirectory);
    String[] pathnames = f.list();
    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList(pathnames));
    return list.stream().filter(str -> str.endsWith(".csv")).collect(Collectors.toList());
  }



  public Csvfile getasCsvfileobj(String CSVdirectory) {
    log.info("**** " + CSVdirectory + "loading **** ");
    CSVreader reader = new CSVreader();
    Csvfile file = reader.readIntoCSVobject(CSVdirectory);
    File f = new File(CSVdirectory);
    file.setFilename(f.getName());
    return file;
  }

}
