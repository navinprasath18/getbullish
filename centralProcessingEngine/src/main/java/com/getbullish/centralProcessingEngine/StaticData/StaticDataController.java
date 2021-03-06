package com.getbullish.centralProcessingEngine.StaticData;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.config.URLutils;
import com.getbullish.centralProcessingEngine.populateHistory.LoadHistoricData;
import com.getbullish.centralProcessingEngine.service.SectorService;

@RestController
@RequestMapping(URLutils.api + URLutils.initialData)
public class StaticDataController {
  @Autowired
  LoaderService service;
  @Autowired
  SectorService sectorService;
  @Autowired
  LoadHistoricData historySerive;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public String create() {
    sectorService.loadstaticdata();
    return service.loadAllCSVFilesInDirectory();

  }

  @PostMapping("/loadsector")
  @ResponseStatus(HttpStatus.OK)
  public List<Sector> loadstaticData() {
    return sectorService.loadstaticdata();

  }

  @PostMapping("/loadHistory")
  @ResponseStatus(HttpStatus.OK)
  public String loadHistory() {
    return historySerive.load();

  }

}
