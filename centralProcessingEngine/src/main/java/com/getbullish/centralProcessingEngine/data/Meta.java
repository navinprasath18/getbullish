package com.getbullish.centralProcessingEngine.data;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Meta {

  private String symbol;
  private String companyName;
  private String industry;
  ArrayList<Object> activeSeries = new ArrayList<Object>();
  ArrayList<Object> debtSeries = new ArrayList<Object>();
  ArrayList<Object> tempSuspendedSeries = new ArrayList<Object>();
  private boolean isFNOSec;
  private boolean isCASec;
  private boolean isSLBSec;
  private boolean isDebtSec;
  private boolean isSuspended;
  private boolean isETFSec;
  private boolean isDelisted;
  private String isin;


}
