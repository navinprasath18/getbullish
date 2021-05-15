package com.getbullish.centralProcessingEngine.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.getbullish.centralProcessingEngine.Entities.Sector;
import com.getbullish.centralProcessingEngine.config.URLutils;
import com.getbullish.centralProcessingEngine.service.SectorServiceImplementation;

@RestController
@RequestMapping(URLutils.api + URLutils.sectorurl)
public class SectorController {

  @Autowired
  SectorServiceImplementation service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Sector> getAllSectors() {
    return service.getAllSectors();
  }


  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void create() {
    service.create();

  }



  @PostMapping("/loadstaticdata")
  @ResponseStatus(HttpStatus.OK)
  public List<Sector> loadstaticData() {
    return service.loadstaticdata();

  }

}
