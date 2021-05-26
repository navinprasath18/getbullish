package com.getbullish.centralProcessingEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.getbullish.centralProcessingEngine.config.URLutils;
import com.getbullish.centralProcessingEngine.multithreadedLoader.AsyncHistoryLoader;

@RestController
@RequestMapping(URLutils.api + URLutils.loadhistory)
public class HistoryController {
  @Autowired
  AsyncHistoryLoader service;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void create() {
    service.start();

  }

}
