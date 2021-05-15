package com.getbullish.centralProcessingEngine.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.getbullish.centralProcessingEngine.config.URLutils;
import com.getbullish.centralProcessingEngine.data.StockData;
import com.getbullish.centralProcessingEngine.service.StockServiceImplementation;

@RestController
@RequestMapping(URLutils.api + URLutils.stockurl)
public class StockController {


  @Autowired
  StockServiceImplementation service;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void create() {
    service.create();

  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<StockData> getAllSectors() {
    return service.getAllStocks();
  }

}
