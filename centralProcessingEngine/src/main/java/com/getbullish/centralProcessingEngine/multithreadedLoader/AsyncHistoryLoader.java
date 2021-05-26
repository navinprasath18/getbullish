package com.getbullish.centralProcessingEngine.multithreadedLoader;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsyncHistoryLoader {

  @Autowired
  CSVfinderService csvService;

  @Autowired
  DummyAsycThread dummysaver;

  @Autowired
  ProcessAndSaveService saver;



  public void start() {
    List<String> dir = csvService.get();
    System.out.print(dir);
    for (String str : dir) {
      saver.processEachDirectoryAndSave(str);
    }
  }

}
