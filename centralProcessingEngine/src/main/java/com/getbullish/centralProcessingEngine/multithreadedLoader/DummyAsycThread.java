package com.getbullish.centralProcessingEngine.multithreadedLoader;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DummyAsycThread {

  @Async("historyloaderbean")
  public void asyncprinter(String dir) {
    log.info("thread started", dir.substring(25));
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {

      log.error("thread interupeted", e.getMessage());
    }
  }

}
