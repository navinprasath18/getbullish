package com.getbullish.centralProcessingEngine.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuarterlyResultsURLEntityData extends DataIdentity {

  private static final long serialVersionUID = 1L;



  String symbol;


  String companyName;



  String industry;

  String audited;



  String cumulative;



  String indAs;



  String period;

  String relatingTo;

  String financialYear;



  String filingDate;


  String seqNumber;



  String bank;


  String fromDate;

  String toDate;

  String oldNewFlag;


  String xbrl;



  String format;


  String resultDescription;


  String resultDetailedDataLink;



  String isin;



  String consolidated;


  boolean processed;


}
