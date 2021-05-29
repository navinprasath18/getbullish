package com.getbullish.centralProcessingEngine.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(includeFieldNames = true)
@Table(name = "filingdata")
public class QuarterlyResultsURLEntity extends EntityIdentity {
  /**
  * 
  */
  private static final long serialVersionUID = 1L;



  @Column(name = "symbol")
  String symbol;


  @Column(name = "companyname", nullable = false)
  String companyName;


  @Column(name = "industry")
  String industry;

  @Column(name = "audited")
  String audited;


  @Column(name = "cumulative")
  String cumulative;


  @Column(name = "indas")
  String indAs;



  @Column(name = "period")
  String period;

  @Column(name = "relatingtto")
  String relatingTo;

  @Column(name = "financialyear")
  String financialYear;

  @Column(name = "filingdate")
  String filingDate;


  @Column(name = "seqnumber")
  String seqNumber;


  @Column(name = "bank")
  String bank;

  @Column(name = "fromdate")
  String fromDate;


  @Column(name = "todate")
  String toDate;


  @Column(name = "oldnewflag")
  String oldNewFlag;


  @Column(name = "url")
  String xbrl;


  @Column(name = "format")
  String format;

  @Column(name = "resultdescription")
  String resultDescription;

  @Column(name = "resultdetaileddatalink")
  String resultDetailedDataLink;


  @Column(name = "isin")
  String isin;


  @Column(name = "consolidated")
  String consolidated;

  @Column(name = "isprocessed")
  boolean processed;

}
