package com.getbullish.centralProcessingEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.getbullish.centralProcessingEngine.config.URLutils;
import com.getbullish.centralProcessingEngine.nseXMLparser.ApchclientTest;
import com.getbullish.centralProcessingEngine.nseXMLparser.PopulatefromNSEurltoFilingDataURL;
import com.getbullish.centralProcessingEngine.nseXMLparser.StoreQuartelyFIlingXMLasJSON;
import com.getbullish.centralProcessingEngine.nseXMLparser.XMLdownloader;

@RestController
@RequestMapping(URLutils.api + URLutils.quarterlyresults)
public class QuarterlyResultsController {

  @Autowired
  PopulatefromNSEurltoFilingDataURL service;

  @Autowired
  ApchclientTest testingserv;

  @Autowired
  StoreQuartelyFIlingXMLasJSON storeXMLasJSON;

  @Autowired
  XMLdownloader xmldownloader;

  @PostMapping("/load")
  @ResponseStatus(HttpStatus.OK)
  public void loadnewURLS() {

    service.populate();
  }


  @PostMapping("/process")
  @ResponseStatus(HttpStatus.OK)
  public void processXMLfiles() {


  }

  @PostMapping("/getjsons")
  @ResponseStatus(HttpStatus.OK)
  public void startdownload() {

    testingserv.startdownload();
  }

  @PostMapping("/storeXMLasJSON")
  @ResponseStatus(HttpStatus.OK)
  public void storeXMLasJSON() {

    storeXMLasJSON.store();
  }


  @PostMapping("/downloadXMLS")
  @ResponseStatus(HttpStatus.OK)
  public void xmldownloader() {

    xmldownloader.startdownload();;
  }

}
