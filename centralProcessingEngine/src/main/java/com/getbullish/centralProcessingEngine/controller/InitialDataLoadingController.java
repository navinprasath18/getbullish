package com.getbullish.centralProcessingEngine.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import com.getbullish.centralProcessingEngine.NseCSVDataReaderSeevice.LoaderService;
import com.getbullish.centralProcessingEngine.config.URLutils;

@RestController
@RequestMapping(URLutils.api + URLutils.initialData)
public class InitialDataLoadingController {
  @Autowired
  LoaderService service;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Stock> create() {
    return service.loadStaticdata();

  }

}
